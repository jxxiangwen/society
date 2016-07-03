package cn.edu.shu.society.rest;


import cn.edu.shu.society.service.VoteTopicService;
import cn.edu.shu.society.util.ConstantUtil;
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

    /**
     * 记名投票处理方法
     * @param pageNum
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/name/{pageNum}", method = RequestMethod.GET)
    public ModelAndView nameVote(@PathVariable("pageNum") Integer pageNum)
            throws Exception {
        voteTopicService.selectByPage(pageNum, ConstantUtil.PAGE_SIZE);
        return new ModelAndView("vote/nameVote");
    }

    /**
     * 匿名投票处理方法
     * @param pageNum
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/anony/{pageNum}", method = RequestMethod.GET)
    public ModelAndView anonyVote(@PathVariable("pageNum") Integer pageNum)
            throws Exception {
        return new ModelAndView("vote/anonyVote");
    }
}
