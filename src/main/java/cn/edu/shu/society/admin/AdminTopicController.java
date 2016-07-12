package cn.edu.shu.society.admin;


import cn.edu.shu.society.dto.VoteTopicDTO;
import cn.edu.shu.society.service.VoteTopicService;
import cn.edu.shu.society.service.VoteTypeService;
import cn.edu.shu.society.util.ConstantUtil;
import com.github.pagehelper.PageInfo;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping(value = "/add/{voteTopicId}", method = RequestMethod.GET)
    public ModelAndView add(@PathVariable(value = "voteTopicId") Long voteTopicId) {
        ModelAndView modelAndView = new ModelAndView("/admin/vote/add");
        return modelAndView;
    }

    /**
     * 投票增加方法
     *
     * @param typeName
     * @param parentName
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@RequestParam("typeName") String typeName, @RequestParam("parentName") String parentName) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/topic/check/page/1");
        return modelAndView;
    }

    /**
     * 显示修改投票页面
     *
     * @return
     */
    @RequestMapping(value = "/add/{voteTopicId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable(value = "voteTopicId") Long voteTopicId) {
        ModelAndView modelAndView = new ModelAndView("/admin/vote/update");
        return modelAndView;
    }

    /**
     * 投票修改方法
     *
     * @param typeId
     * @param typeName
     * @param parentName
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("typeId") Long typeId, @RequestParam("typeName") String typeName, @RequestParam("parentName") String parentName) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/topic/check/page/1");
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
}
