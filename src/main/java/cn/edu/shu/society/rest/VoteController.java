package cn.edu.shu.society.rest;


import cn.edu.shu.society.annotation.Token;
import cn.edu.shu.society.dto.UserDTO;
import cn.edu.shu.society.dto.VoteResultMap;
import cn.edu.shu.society.dto.VoteTopicDTO;
import cn.edu.shu.society.enums.ClientError;
import cn.edu.shu.society.enums.VoteError;
import cn.edu.shu.society.exception.AppViewException;
import cn.edu.shu.society.service.VoteItemService;
import cn.edu.shu.society.service.VoteSubjectResultService;
import cn.edu.shu.society.service.VoteSubjectService;
import cn.edu.shu.society.service.VoteTopicService;
import cn.edu.shu.society.util.ConstantUtil;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


@Api(value = "vote", description = "投票操作相关API")
@RestController
@RequestMapping(value = "/vote")
public class VoteController {

    private static final Logger logger = LoggerFactory.getLogger(VoteController.class);

    @Autowired
    VoteTopicService voteTopicService;

    @Autowired
    VoteSubjectService voteSubjectService;

    @Autowired
    VoteItemService voteItemService;

    @Autowired
    VoteSubjectResultService voteSubjectResultService;

    /**
     * 投票处理方法
     *
     * @param voteTypeId
     * @param pageNum
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/topic/{voteTypeId}/page/{pageNum}", method = RequestMethod.GET)
    public ModelAndView vote(@PathVariable("voteTypeId") Long voteTypeId, @PathVariable("pageNum") Integer pageNum)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("vote/vote");
        PageInfo<VoteTopicDTO> voteTopicDTOPageInfo = voteTopicService.selectByVoteTypeIdAndPage(voteTypeId, pageNum, ConstantUtil.PAGE_SIZE);
        modelAndView.addObject("pageInfo", voteTopicDTOPageInfo);
        modelAndView.addObject("voteTypeId", voteTypeId);
        return modelAndView;
    }

    /**
     * 获取某一投票
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Token(save = true)
    @RequestMapping(value = "/topic/{id}", method = RequestMethod.GET)
    public ModelAndView topic(@PathVariable("id") Long id)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("vote/topic");
        VoteTopicDTO voteTopicDTO = voteTopicService.selectListByPrimaryKey(id);
        if (null == voteTopicDTO) {
            throw new AppViewException(VoteError.VOTE_NOT_EXIST.getMsg(), VoteError.VOTE_NOT_EXIST.getCode());
        }
        if (new Date().getTime() > voteTopicDTO.getEndTime() * 1000) {
            throw new AppViewException(VoteError.VOTE_HAVE_OVERTIME.getMsg(), VoteError.VOTE_HAVE_OVERTIME.getCode());
        }
        if (new Date().getTime() < voteTopicDTO.getStartTime() * 1000) {
            throw new AppViewException(VoteError.VOTE_NOT_BEGIN.getMsg(), VoteError.VOTE_NOT_BEGIN.getCode());
        }
        modelAndView.addObject("voteTopic", voteTopicDTO);
        return modelAndView;
    }

    /**
     * 投票保存
     *
     * @return
     */
    @Token(remove = true)
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(VoteResultMap voteResultMap,
                             HttpServletRequest request) {
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        Long id = Long.parseLong(request.getParameter("id"));
        boolean result = voteSubjectResultService.saveVoteResult(userDTO.getUserId(), id, voteResultMap);
        if (!result) {
            throw new AppViewException(ClientError.SYSTEM_WRONG.getMsg());
        }
        return new ModelAndView("redirect:/vote/check/topic/" + id);
    }

    /**
     * 投票保存
     *
     * @return
     */
    @RequestMapping(value = "/check/topic/{voteTopicId}", method = RequestMethod.GET)
    public ModelAndView check(@PathVariable(value = "voteTopicId") Long voteTopicId) {
        VoteTopicDTO voteTopicDTO = voteSubjectResultService.getVoteResult(voteTopicId);
        if (null == voteTopicDTO) {
            throw new AppViewException(VoteError.VOTE_NOW_NOT_EXIST.getMsg(),VoteError.VOTE_NOW_NOT_EXIST.getCode());
        }
        ModelAndView modelAndView = new ModelAndView("vote/success");
        modelAndView.addObject("voteTopic", voteTopicDTO);
        return modelAndView;
    }
}