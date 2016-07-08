package cn.edu.shu.society.admin;


import cn.edu.shu.society.dto.VoteTopicDTO;
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
@RequestMapping(value = "/admin/vote")
public class AdminVoteController {

    private static final Logger logger = LoggerFactory.getLogger(AdminVoteController.class);

    @Autowired
    VoteTopicService voteTopicService;

    /**
     * 投票处理方法
     *
     * @param pageNum
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/vote/{voteTypeId}/name/{pageNum}", method = RequestMethod.GET)
    public ModelAndView vote(@PathVariable("voteTypeId") Long voteTypeId,@PathVariable("pageNum") Integer pageNum)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("vote/nameVote");
        PageInfo<VoteTopicDTO> voteTopicDTOPageInfo = voteTopicService.selectByVoteTypeIdAndPage(voteTypeId, pageNum, ConstantUtil.PAGE_SIZE);
        modelAndView.addObject("voteTopicList", voteTopicDTOPageInfo);
        return modelAndView;
    }
}
