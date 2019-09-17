package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author: Zoé
 * @date: 2019/9/12 下午7:02
 * @describe: TODO
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
