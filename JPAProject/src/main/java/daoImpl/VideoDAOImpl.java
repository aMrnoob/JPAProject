package daoImpl;

import java.util.List;

import config.JPAConfig;
import dao.VideoDAO;
import entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class VideoDAOImpl implements VideoDAO{

	@Override
    public int countVideo() {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            String jpql = "SELECT COUNT(v) FROM Video v";
            TypedQuery<Long> query = enma.createQuery(jpql, Long.class);
            return query.getSingleResult().intValue();
        } finally {
            enma.close();
        }
    }

    @Override
    public List<Video> findAllVideo() {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            String jpql = "SELECT v FROM Video v";
            TypedQuery<Video> query = enma.createQuery(jpql, Video.class);
            return query.getResultList();
        } finally {
            enma.close();
        }
    }

    @Override
    public Video findVideoById(String videoId) {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            return enma.find(Video.class, videoId);
        } finally {
            enma.close();
        }
    }

    @Override
    public void deleteVideo(String videoId) throws Exception {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            Video video = enma.find(Video.class, videoId);
            if (video != null) {
                enma.remove(video);
            } else {
                throw new Exception("Không tìm thấy video với ID: " + videoId);
            }
            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void updateVideo(Video video) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(video);
            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void insertVideo(Video video) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(video);
            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            throw e;
        } finally {
            enma.close();
        }
    }
}
