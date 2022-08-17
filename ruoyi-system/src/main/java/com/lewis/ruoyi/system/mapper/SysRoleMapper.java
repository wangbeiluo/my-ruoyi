package com.lewis.ruoyi.system.mapper;

import com.lewis.ruoyi.common.core.domain.entity.SysRole;

import java.util.List;

/**
 * @author lewis
 * @description: 角色表 数据层
 * @date: 2022/8/16
 * @Copyright:
 */
public interface SysRoleMapper
{
    /**
     * 根据条件分页查询角色数据
     *
     * @param role
     * @return
     */
    public List<SysRole> selectRoleList(SysRole role);

    /**
     * 根据用户ID查询角色
     *
     * @param userId
     * @return
     */
    public List<SysRole> selectRolePermissionByUserId(Long userId);

    /**
     * 根据用户名查询角色
     *
     * @param userName
     * @return
     */
    public List<SysRole> selectRolesByUserName(String userName);

    /**
     * 查询所有角色
     *
     * @return
     */
    public List<SysRole> selectRoleAll();

    /**
     * 根据用户ID获取角色选择框列表
     *
     * @param userId
     * @return
     */
    public List<Long> selectRoleListByUserId(Long userId);

    /**
     * 通过角色ID查询角色
     *
     * @param roleId
     * @return
     */
    public SysRole selectRoleById(Long roleId);

    /**
     * 校验角色名称是否唯一
     *
     * @param roleName 角色名称
     * @return 角色信息
     */
    public SysRole checkRoleNameUnique(String roleName);

    /**
     * 校验角色权限是否唯一
     *
     * @param roleKey 角色权限
     * @return 角色信息
     */
    public SysRole checkRoleKeyUnique(String roleKey);

    /**
     * 修改角色信息
     *
     * @param role 角色信息
     * @return 结果
     */
    public int updateRole(SysRole role);

    /**
     * 新增角色信息
     *
     * @param role 角色信息
     * @return 结果
     */
    public int insertRole(SysRole role);

    /**
     * 通过角色ID删除角色
     *
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteRoleById(Long roleId);

    /**
     * 批量删除角色信息
     *
     * @param roleIds 需要删除的角色ID
     * @return 结果
     */
    public int deleteRoleByIds(Long[] roleIds);
}
