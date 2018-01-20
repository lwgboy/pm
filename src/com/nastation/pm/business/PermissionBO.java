package com.nastation.pm.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

<<<<<<< HEAD
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nastation.pm.bean.Permission;
import com.nastation.pm.beanhbm.Permissionhbm;
import com.nastation.pm.util.DBConn;
import com.nastation.pm.util.SessionF;
=======
import org.hibernate.*;
import com.nastation.pm.beanhbm.*;
>>>>>>> f483d34e679984b11c23ea8a44763ccc5f32c2a9

/**
 * Permission business object.
 *
 * @author sun
 *
 */
public class PermissionBO {

    public static PermissionBO getPermissionBO() {
        return new PermissionBO();
    }

    public Permissionhbm idGetPermission(int id) {
        Session session = SessionF.sessionFactory.openSession();
        Transaction tx = null;
        Permissionhbm p = null;
        try {
            tx = session.beginTransaction();
            p = session.load(Permissionhbm.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null)
                session.close();
        }
        return p;
    }

    /**
     * get all permission
     *
     * @return list
     */
    public List<Permissionhbm> getAllPermission() {
        Session session = SessionF.sessionFactory.openSession();
        Transaction tx = null;
        List<Permissionhbm> l = null;
        try {
            tx = session.beginTransaction();
            l = session.createQuery("from Permissionhbm").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null)
                session.close();
        }
        return l;
    }

    /**
     * 获得所有权限，按权限类型分类。以类型名为Key，该类型下的所有权限列表为Value.
     *
     * @author sun
     * @return
     */
    public HashMap<String, List> getAllTypeList(int schemeId) {
        HashMap hashMap = new HashMap();
        Connection conn = DBConn.getConnection();
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        String sql = "select distinct type_name from t_permission";
        String sql2 = "select * from t_permission where type_name=?";
        try {
            stmt = conn.createStatement();
            rs1 = stmt.executeQuery(sql);
            while (rs1.next()) {
                String type = rs1.getString("type_name");
                List list = new ArrayList();
                pstmt = conn.prepareStatement(sql2);
                pstmt.setString(1, type);
                rs2 = pstmt.executeQuery();
                while (rs2.next()) {
                    Permission permission = new Permission();
                    permission.setId(rs2.getInt("id"));
                    permission.setName(rs2.getString("name"));
                    permission.setDescription(rs2.getString("description"));
                    permission.setTypeName(rs2.getString("type_name"));
                    list.add(permission);
                }
                hashMap.put(type, list);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.closeConn(conn);
        }
        return hashMap;
    }

}
