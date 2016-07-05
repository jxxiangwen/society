package cn.edu.shu.society.rest;


import cn.edu.shu.society.dto.VoteSubjectDTO;
import cn.edu.shu.society.dto.VoteTopicDTO;
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
    @RequestMapping(value = "/vote/{voteTypeId}/page/{pageNum}", method = RequestMethod.GET)
    public ModelAndView vote(@PathVariable("voteTypeId") Long voteTypeId, @PathVariable("pageNum") Integer pageNum)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("vote");
        PageInfo<VoteTopicDTO> voteTopicDTOPageInfo = voteTopicService.selectByVoteTypeIdAndPage(voteTypeId, pageNum, ConstantUtil.PAGE_SIZE);
        modelAndView.addObject("voteTopicList", voteTopicDTOPageInfo);
        return modelAndView;
    }

    /**
     * 获取某一投票
     * @param voteTypeId
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/vote/{voteTypeId}/topic/{id}", method = RequestMethod.GET)
    public ModelAndView topic(@PathVariable("voteTypeId") Long voteTypeId, @PathVariable("id") Long id)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("subject");
        VoteSubjectDTO voteSubjectDTO = voteSubjectService.selectByPrimaryKey(id);
        if(null == voteSubjectDTO){
            return modelAndView;
        }
        modelAndView.addObject("voteSubject", voteSubjectDTO);
        return modelAndView;
    }
}