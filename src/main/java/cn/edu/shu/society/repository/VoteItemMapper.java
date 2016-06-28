package cn.edu.shu.society.repository;

import cn.edu.shu.society.entity.VoteItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote_item
     *
     * @mbggenerated Thu Jun 23 22:16:17 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote_item
     *
     * @mbggenerated Thu Jun 23 22:16:17 CST 2016
     */
    int insert(VoteItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote_item
     *
     * @mbggenerated Thu Jun 23 22:16:17 CST 2016
     */
    VoteItem selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote_item
     *
     * @mbggenerated Thu Jun 23 22:16:17 CST 2016
     */
    List<VoteItem> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote_item
     *
     * @mbggenerated Thu Jun 23 22:16:17 CST 2016
     */
    int updateByPrimaryKey(VoteItem record);
}