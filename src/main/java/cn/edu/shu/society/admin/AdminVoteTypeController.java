package cn.edu.shu.society.admin;


import cn.edu.shu.society.dto.VoteTypeDTO;
import cn.edu.shu.society.service.VoteTopicService;
import cn.edu.shu.society.service.VoteTypeService;
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
@RequestMapping(value = "/admin/vote/type")
public class AdminVoteTypeController {

    private static final Logger logger = LoggerFactory.getLogger(AdminVoteTypeController.class);

    @Autowired
    VoteTopicService voteTopicService;

    @Autowired
    VoteTypeService voteTypeService;

    /**
     * 投票类型get方法
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("admin/vote/type");
        List<VoteTypeDTO> voteTypeDTOList = voteTypeService.selectAll();
        request.setAttribute("voteTypeList",voteTypeDTOList);
        request.setAttribute("nameVote","记名投票");
        request.setAttribute("anonyVote","不记名投票");
        return modelAndView;
    }

    /**
     * 投票类型post方法
     * @param typeName
     * @param parentName
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@RequestParam("typeName") String typeName, @RequestParam("parentName") String parentName)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/vote");
        VoteTypeDTO voteTypeDTO = new VoteTypeDTO();
        voteTypeDTO.setTypeName(typeName);
        voteTypeDTO.setParentTypeName(parentName);
        voteTypeService.insert(voteTypeDTO);
        return modelAndView;
    }

    /**
     * voteTypeDTO
     * @param typeId
     * @param typeName
     * @param parentName
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ModelAndView update(@RequestParam("typeId") Long typeId, @RequestParam("typeName") String typeName, @RequestParam("parentName") String parentName)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/vote");
        VoteTypeDTO voteTypeDTO = voteTypeService.selectByPrimaryKey(typeId);
        voteTypeDTO.setTypeName(typeName);
        voteTypeDTO.setParentTypeName(parentName);
        voteTypeService.updateByPrimaryKey(voteTypeDTO);
        return modelAndView;
    }

    /**
     * 投票类型get方法
     *
     * @param voteTypeId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@RequestBody Long voteTypeId)
            throws Exception {
        voteTypeService.deleteByPrimaryKey(voteTypeId);
        return "success";
    }
}
