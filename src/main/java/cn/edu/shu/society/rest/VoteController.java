package cn.edu.shu.society.rest;


import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
