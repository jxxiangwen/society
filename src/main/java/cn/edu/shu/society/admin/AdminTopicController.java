package cn.edu.shu.society.admin;


import cn.edu.shu.society.dto.VoteTopicDTO;
import cn.edu.shu.society.dto.VoteTypeDTO;
import cn.edu.shu.society.service.VoteTopicService;
import cn.edu.shu.society.service.VoteTypeService;
import cn.edu.shu.society.util.ConstantUtil;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(value = "vote", description = "投票操作相关API")
@RestController
@RequestMapping(value = "/admin/topic")
public class AdminTopicController {

    private static final Logger logger = LoggerFactory.getLogger(AdminTopicController.class);

    @Autowired
    VoteTopicService voteTopicService;

    @Autowired
    VoteTypeService voteTypeService;

    /**
     * 投票处理方法
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
     * 投票类型post方法
     *
     * @param typeName
     * @param parentName
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@RequestParam("typeName") String typeName, @RequestParam("parentName") String parentName) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/topic/page/1");
        return modelAndView;
    }

    /**
     * voteTypeDTO
     *
     * @param typeId
     * @param typeName
     * @param parentName
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ModelAndView update(@RequestParam("typeId") Long typeId, @RequestParam("typeName") String typeName, @RequestParam("parentName") String parentName) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/topic/page/1");
        return modelAndView;
    }

    /**
     * 投票类型get方法
     *
     * @param voteTopicId
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ModelAndView delete(@RequestParam("voteTopicId") Long voteTopicId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/topic/page/1");
        voteTopicService.deleteByPrimaryKey(voteTopicId);
        return modelAndView;
    }
}
