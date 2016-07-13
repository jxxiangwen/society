package cn.edu.shu.society.service.Impl;

import cn.edu.shu.society.dto.ResponseDTO;
import cn.edu.shu.society.entity.Response;
import cn.edu.shu.society.repository.ResponseMapper;
import cn.edu.shu.society.service.ResponseService;
import cn.edu.shu.society.util.BeanUtility;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {
    private static Logger logger = LoggerFactory.getLogger(ResponseServiceImpl.class);

    @Autowired
    ResponseMapper responseMapper;

    /**
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Long id) {
        return responseMapper.deleteByPrimaryKey(id);
    }

    /**
     * @param record
     * @return
     */
    public int insert(ResponseDTO record) {
        return responseMapper.insert(BeanUtility.beanCopy(record, Response.class));
    }

    /**
     * @param id
     * @return
     */
    public ResponseDTO selectByPrimaryKey(Long id) {
        return BeanUtility.beanCopy(responseMapper.selectByPrimaryKey(id), ResponseDTO.class);
    }

    /**
     * @return
     */
    public List<ResponseDTO> selectAll() {
        List<Response> responseList = responseMapper.selectAll();
        Iterator<Response> iterator = responseList.iterator();
        List<ResponseDTO> responseDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            responseDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), ResponseDTO.class));
        }
        return responseDTOLinkedList;
    }

    /**
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<ResponseDTO> selectByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize, "update_time desc");
        List<Response> responseList = responseMapper.selectAll();
        PageInfo<Response> page = new PageInfo(responseList);
        Iterator<Response> iterator = responseList.iterator();
        List<ResponseDTO> responseDTOLinkedList = new LinkedList<>();
        while (iterator.hasNext()) {
            responseDTOLinkedList.add(BeanUtility.beanCopy(iterator.next(), ResponseDTO.class));
        }
        PageInfo<ResponseDTO> page1 = BeanUtility.beanCopy(page, PageInfo.class, "list");
        page1.setList(responseDTOLinkedList);
        return page1;
    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(ResponseDTO record) {
        return responseMapper.updateByPrimaryKey(BeanUtility.beanCopy(record, Response.class));
    }

    @Override
    public List<ResponseDTO> selectByMessageId(Long messageId) {
        return BeanUtility.convertOtherBeanList(responseMapper.selectByMessageId(messageId), ResponseDTO.class);
    }

    @Override
    public List<ResponseDTO> selectResAndNameByMessageId(Long messageId) {
        return BeanUtility.convertOtherBeanList(responseMapper.selectResAndNameByMessageId(messageId), ResponseDTO.class);
    }

    @Override
    public int deleteByMessageId(Long messageId) {
        return responseMapper.deleteByMessageId(messageId);
    }


}