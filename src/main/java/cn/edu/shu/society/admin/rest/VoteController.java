package cn.edu.shu.society.admin.rest;


import cn.edu.shu.society.service.VoteTopicService;
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
public class VoteController {

    private static final Logger logger = LoggerFactory.getLogger(VoteController.class);

    @Autowired
    VoteTopicService voteTopicService;

    @RequestMapping(value = "/name/{number}", method = RequestMethod.GET)
    public ModelAndView uploadOffice(@PathVariable("number") String number)
            throws Exception {
        return new ModelAndView("vote/nameVote");
    }

    @RequestMapping(value = "/anony/{number}", method = RequestMethod.GET)
    public ModelAndView downloadOffice(@PathVariable("number") String number)
            throws Exception {
        return new ModelAndView("vote/anonyVote");
    }
}
