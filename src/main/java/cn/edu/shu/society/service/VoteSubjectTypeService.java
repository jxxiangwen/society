package cn.edu.shu.society.service;

import cn.edu.shu.society.dto.VoteSubjectTypeDTO;
import cn.edu.shu.society.entity.VoteSubjectType;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoteSubjectTypeService {
    /**
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @param record
     * @return
     */
    int insert(VoteSubjectTypeDTO record);

    /**
     * @param id
     * @return
     */
    VoteSubjectTypeDTO selectByPrimaryKey(Long id);

    /**
     * @return
     */
    List<VoteSubjectTypeDTO> selectAll();

    /**
     * @return
     */
    PageInfo<VoteSubjectTypeDTO> selectByPage(int pageNum, int pageSize);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(VoteSubjectTypeDTO record);

    /**
     *
     * @param typeName
     * @return
     */
    Long selectIdByTypeName(String typeName);
}