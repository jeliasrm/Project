package com.seck.profesores.dao;

import java.util.List;

import com.seck.profesores.model.SocialMedia;
import com.seck.profesores.model.TeacherSocialMedia;

public interface SocialMediaDao {
	void saveSocialMedia(SocialMedia socialMedia);
	
	void deleteSocialMediaById(Long id);
	
	void updateSocialMedia(SocialMedia socialMedia);
	
	List<SocialMedia> findAllSocialMedias();
	
	SocialMedia findById(Long idSocialMedia);
	
	SocialMedia findByName(String name);
	
	TeacherSocialMedia findSocialMediaByIdAndName(Long idSocialMedia, String nickname);
	
}
