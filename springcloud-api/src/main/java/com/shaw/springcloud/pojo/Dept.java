package com.shaw.springcloud.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 部门表
 * @TableName dept
 */
@TableName(value ="dept")
@Data
@NoArgsConstructor
@Accessors(chain = true)
//链式写法
public class Dept implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long deptno;

    /**
     *
     */
    private String dname;

    /**
     *
     */
    private String dbResource;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Dept other = (Dept) that;
        return (this.getDeptno() == null ? other.getDeptno() == null : this.getDeptno().equals(other.getDeptno()))
            && (this.getDname() == null ? other.getDname() == null : this.getDname().equals(other.getDname()))
            && (this.getDbResource() == null ? other.getDbResource() == null : this.getDbResource().equals(other.getDbResource()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDeptno() == null) ? 0 : getDeptno().hashCode());
        result = prime * result + ((getDname() == null) ? 0 : getDname().hashCode());
        result = prime * result + ((getDbResource() == null) ? 0 : getDbResource().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptno=").append(deptno);
        sb.append(", dname=").append(dname);
        sb.append(", dbResource=").append(dbResource);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
