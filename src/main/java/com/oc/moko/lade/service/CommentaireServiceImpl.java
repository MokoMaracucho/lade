package com.oc.moko.lade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.entity.Commentaire;
import com.oc.moko.lade.repository.CommentaireRepository;

@Service
public class CommentaireServiceImpl implements CommentaireService {
	
	@Autowired
    private CommentaireRepository commentaireRepository;

	@Override
    @Transactional
	public List<Commentaire> listeCommentaires() {
        return commentaireRepository.findAll();
	}

	@Override
    @Transactional
	public List<Commentaire> listeCommentairesByIdSite(Long idSite) {
        return commentaireRepository.findAllByIdSite(idSite);
	}

	@Override
	public void supprimerCommentaireById(Long idCommentaire) {
		commentaireRepository.deleteById(idCommentaire);
	}
}
