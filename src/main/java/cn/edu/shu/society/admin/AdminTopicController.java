package cn.edu.shu.society.admin;


import cn.edu.shu.society.annotation.Token;
import cn.edu.shu.society.dto.*;
import cn.edu.shu.society.enums.VoteError;
import cn.edu.shu.society.exception.AppViewException;
import cn.edu.shu.society.service.VoteSubjectTypeService;
import cn.edu.shu.society.service.VoteTopicService;
import cn.edu.shu.society.service.VoteTypeService;
import cn.edu.shu.society.util.ConstantUtil;
import cn.edu.shu.society.util.MapUtil;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Api(value = "topic", description = "投票操作相关API")
@RestController
@RequestMapping(value = "/admin/topic")
public class AdminTopicController {

    private static final Logger logger = LoggerFactory.getLogger(AdminTopicController.class);

    @Autowired
    VoteTopicService voteTopicService;

    @Autowired
    VoteTypeService voteTypeService;

    @Autowired
    VoteSubjectTypeService voteSubjectTypeService;

    /**
     * 查看投票方法
     *
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/check/page/{pageNum}", method = RequestMethod.GET)
    public ModelAndView check(@PathVariable("pageNum") Integer pageNum) {
        ModelAndView modelAndView = new ModelAndView("/admin/vote/vote");
        PageInfo<VoteTopicDTO> voteTopicDTOPageInfo = voteTopicService.selectAllByPage(pageNum, ConstantUtil.PAGE_SIZE);
        modelAndView.addObject("pageInfo", voteTopicDTOPageInfo);
        return modelAndView;
    }

    /**
     * 显示增加投票页面
     *
     * @return
     */
//    @Token(save = true)
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/admin/vote/add");
        List<VoteTypeDTO> voteTypeDTOList = voteTypeService.selectAll();
        request.setAttribute("voteTypeList", voteTypeDTOList);
        return modelAndView;
    }

    /**
     * 投票增加方法
     *
     * @return
     */
//    @Token(remove = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(TopicDTO topicDTO, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/topic/check/page/1");
        AdminUserDTO adminUserDTO = (AdminUserDTO)request.getSession().getAttribute("adminUser");
        voteTopicService.saveOrUpdate(topicDTO,adminUserDTO.getUserId(),null);
        return modelAndView;
    }

    /**
     * 显示修改投票页面
     *
     * @return
     */
//    @Token(save = true)
    @RequestMapping(value = "/update/{voteTopicId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable(value = "voteTopicId") Long voteTopicId, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/admin/vote/update");
        VoteTopicDTO voteTopicDTO = voteTopicService.selectListByPrimaryKey(voteTopicId);
        if (null == voteTopicDTO) {
            throw new AppViewException(VoteError.VOTE_NOT_EXIST.getMsg(), VoteError.VOTE_NOT_EXIST.getCode());
        }
        modelAndView.addObject("voteTopic", voteTopicDTO);
        List<VoteTypeDTO> voteTypeDTOList = voteTypeService.selectAll();
        request.setAttribute("voteTypeList", voteTypeDTOList);
        List<VoteSubjectTypeDTO> voteSubjectTypeDTOList = voteSubjectTypeService.selectAll();
        request.setAttribute("voteSubjectTypeList", voteSubjectTypeDTOList);
        return modelAndView;
    }

    /**
     * 投票修改方法
     * @param topicDTO
     * @param request
     * @return
     */
//    @Token(remove = true)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(TopicDTO topicDTO, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/topic/check/page/1");
        VoteTopicDTO voteTopicDTO = voteTopicService.selectListByPrimaryKey(topicDTO.getTopicId());
        Map<String,Set<Long>> IdMap = MapUtil.getIdMapByTopic(voteTopicDTO);
        AdminUserDTO adminUserDTO = (AdminUserDTO)request.getSession().getAttribute("adminUser");
        voteTopicService.saveOrUpdate(topicDTO,adminUserDTO.getUserId(),IdMap);
        return modelAndView;
    }

    /**
     * 投票删除方法
     *
     * @param voteTopicId
     * @return
     */
    @RequestMapping(value = "/delete/{voteTopicId}", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable("voteTopicId") Long voteTopicId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/topic/check/page/1");
        voteTopicService.deleteByPrimaryKey(voteTopicId);
        return modelAndView;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
