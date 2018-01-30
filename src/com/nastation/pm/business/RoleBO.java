package com.nastation.pm.business;

import java.sql.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nastation.pm.beanhbm.Rolehbm;
import com.nastation.pm.util.DBConn;
import com.nastation.pm.util.SessionF;

/**
 * 
 * @author zhanglei
 * 
 */
public class RoleBO {

    public static RoleBO getRoleBO() {
        return new RoleBO();
    }

    /**
     * 创建一个角色
     */

    public void addRole(Rolehbm role) {
        Session session = SessionF.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(role);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
    }

    /**
     * 通过一个ID获得对应的角色
     */

    public Rolehbm getRole(int id) {
        Session session = SessionF.sessionFactory.openSession();
        Transaction tx = null;
        Rolehbm r2 = null;
        try {
            tx = session.beginTransaction();
            r2 = session.load(Rolehbm.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return r2;
    }

    /**
     * 检查是否创建了同名角色
     */
    public boolean checkRole(Rolehbm role) {
        boolean flag = false;
        Connection conn = DBConn.getConnection();
        try {
            String sql = "select * from t_role where role_name=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, role.getRoleName());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.closeConn(conn);
        }
        return flag;
    }

    /**
     * 获得数据库中所有的角色信息
     */

    public List<Rolehbm> getRoleList() {
        Session session = SessionF.sessionFactory.openSession();
        Transaction tx = null;
        List<Rolehbm> r2List = null;
        try {
            tx = session.beginTransaction();
            r2List = session.createQuery("from Rolehbm").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return r2List;
    }

    /**
     * 删除对应ID的角色
     */

    public void deleteRole(int id) {
        Session session = SessionF.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(session.load(Rolehbm.class, id));
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
    }

    /**
     * 更新角色
     */

    public void updateRole(Rolehbm role) {
        Session session = SessionF.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(role);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
    }

    /**
     * 检查是否此角色有关联的对象
     */
    public boolean checkRoleByLink(int roleId) {
        Connection conn = DBConn.getConnection();
        try {
            String sql = "select * from t_project_user where role_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, roleId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConn.closeConn(conn);
        }
        return false;
    }

}
