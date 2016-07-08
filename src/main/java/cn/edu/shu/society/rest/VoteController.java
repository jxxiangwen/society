package cn.edu.shu.society.rest;


import cn.edu.shu.society.dto.VoteTopicDTO;
import cn.edu.shu.society.enums.VoteError;
import cn.edu.shu.society.exception.AppViewException;
import cn.edu.shu.society.service.VoteItemService;
import cn.edu.shu.society.service.VoteSubjectService;
import cn.edu.shu.society.service.VoteTopicService;
import cn.edu.shu.society.util.ConstantUtil;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


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
        modelAndView.addObject("voteTopicList", voteTopicDTOPageInfo);
        return modelAndView;
    }

    /**
     * 获取某一投票
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/topic/{id}", method = RequestMethod.GET)
    public ModelAndView topic(@PathVariable("id") Long id)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("vote/topic");
        VoteTopicDTO voteTopicDTO = voteTopicService.selectListByPrimaryKey(id);
        if(null == voteTopicDTO){
            throw new AppViewException(VoteError.VOTE_NOT_EXIST.getMsg(),VoteError.VOTE_NOT_EXIST.getCode());
        }
        modelAndView.addObject("voteTopic", voteTopicDTO);
        return modelAndView;
    }

    /**
     * 投票保存
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(){
        ModelAndView modelAndView = new ModelAndView("vote/success");

        return modelAndView;
    }
}