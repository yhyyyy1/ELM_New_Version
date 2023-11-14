package com.neusoft.elmboot.mapper;

import com.neusoft.elmboot.model.bo.PointTurnover;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface PointTurnoverMapper {

    @Insert("insert into pointturnover values (?,#{pointId},#{userId},#{state},#{amount},#{createTime},0)")
    int savePointTurnover(Long pointId, String userId, String state, Insert amount, String createTime) throws SQLException;

    //todo 更新查询逻辑

    /**
     * 用于获取未使用积分
     *
     * @param pointId
     * @param userId
     * @return
     */
    @Select("SELECT * FROM pointturnover WHERE userId = #{userId} AND pointId = #{pointId} AND state LIKE 'A%'")
    List<PointTurnover> getPointTurnover(Long pointId, String userId) throws SQLException;

    /**
     * 用于查询流水
     *
     * @param pointId
     * @param userId
     * @param state
     * @return
     */
    @Select("SELECT * FROM pointturnover WHERE userId =#{userId} and pointId =#{pointId} and state =#{state}")
    List<PointTurnover> getPointTurnover(Long pointId, String userId, String state) throws SQLException;

    @Update("UPDATE pointturnover SET state =#{state} WHERE id = #{id} and userId =#{userId} and pointId =#{pointId}")
    int updateState(Long id, Long pointId, String userId, String state) throws SQLException;
}
