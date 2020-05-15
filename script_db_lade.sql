CREATE DATABASE db_lade CHARACTER SET utf8mb4;

CREATE TABLE db_lade.tb_utilisateur (
    id_utilisateur INTEGER AUTO_INCREMENT,
    prenom_utilisateur VARCHAR(30) NOT NULL,
    nom_utilisateur VARCHAR(30) NOT NULL,
    email_utilisateur VARCHAR(50) NOT NULL,
    mot_de_passe_utilisateur VARCHAR(56) NOT NULL,
    privilege_utilisateur VARCHAR(21) NOT NULL,
    date_inscription_utilisateur TIMESTAMP NOT NULL,
    PRIMARY KEY (id_utilisateur)
)
ENGINE=INNODB;

CREATE TABLE db_lade.tb_site (
    id_site INTEGER AUTO_INCREMENT,
    nom_site VARCHAR(30) NOT NULL,
    region_site VARCHAR(30) NOT NULL,
    id_utilisateur INTEGER NOT NULL,
    PRIMARY KEY (id_site),
    CONSTRAINT fk_id_utilisateur FOREIGN KEY (id_utilisateur) REFERENCES tb_utilisateur(id_utilisateur) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = INNODB;

CREATE TABLE db_lade.tb_commentaire (
    id_commentaire INTEGER AUTO_INCREMENT,
    id_auteur_commentaire INTEGER NOT NULL,
    id_site_commentaire INTEGER NOT NULL,
    commentaire VARCHAR(250),
    PRIMARY KEY (id_commentaire),
    CONSTRAINT id_auteur_commentaire FOREIGN KEY (id_auteur_commentaire) REFERENCES tb_utilisateur(id_utilisateur) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT id_site_commentaire FOREIGN KEY (id_site_commentaire) REFERENCES tb_site(id_site) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = INNODB;

CREATE TABLE db_lade.tb_secteur (
    id_secteur INTEGER AUTO_INCREMENT,
    nom_secteur VARCHAR(30) NOT NULL,
    id_utilisateur INTEGER NOT NULL,
    id_site INTEGER NOT NULL,
    PRIMARY KEY (id_secteur),
    CONSTRAINT fk_id_utilisateur FOREIGN KEY (id_utilisateur) REFERENCES tb_utilisateur(id_utilisateur) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_id_site FOREIGN KEY (id_site) REFERENCES tb_site(id_site) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = INNODB;

CREATE TABLE db_lade.tb_voie (
    id_voie INTEGER AUTO_INCREMENT,
    nom_voie VARCHAR(30) NOT NULL,
    equipe_voie BOOLEAN NOT NULL,
    cotation_voie VARCHAR(3) NOT NULL,
    id_utilisateur INTEGER NOT NULL,
    id_secteur INTEGER NOT NULL,
    PRIMARY KEY (id_voie),
    CONSTRAINT fk_id_utilisateur FOREIGN KEY (id_utilisateur) REFERENCES tb_utilisateur(id_utilisateur) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_id_secteur FOREIGN KEY (id_secteur) REFERENCES tb_secteur(id_secteur) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = INNODB;

CREATE TABLE db_lade.tb_longueur (
    id_longueur INTEGER AUTO_INCREMENT,
    nom_longueur VARCHAR(30) NOT NULL,
    cotation_longueur VARCHAR(3) NOT NULL,
    id_utilisateur INTEGER NOT NULL,
    id_voie INTEGER NOT NULL,
    PRIMARY KEY (id_longueur),
    CONSTRAINT fk_id_utilisateur FOREIGN KEY (id_utilisateur) REFERENCES tb_utilisateur(id_utilisateur) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_id_voie FOREIGN KEY (id_voie) REFERENCES tb_voie(id_voie) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = INNODB;

CREATE TABLE db_lade.tb_topo (
    id_topo INTEGER AUTO_INCREMENT,
    nom_topo VARCHAR(30) NOT NULL,
    region_topo VARCHAR(30) NOT NULL,
    description_topo VARCHAR(250) NOT NULL,
    date_parution_topo TIMESTAMP NOT NULL,
    disponibilite_topo BOOLEAN NOT NULL,
    id_utilisateur INTEGER NOT NULL,
    PRIMARY KEY (id_topo),
    CONSTRAINT fk_id_utilisateur FOREIGN KEY (id_utilisateur) REFERENCES tb_utilisateur(id_utilisateur) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = INNODB;

CREATE TABLE db_lade.tb_reservation_topo (
    id_reservation_topo INTEGER AUTO_INCREMENT,
    statut_reservation_topo VARCHAR(17) NOT NULL,
    id_topo_reservation_topo INTEGER NOT NULL,
    id_proprietaire_topo INTEGER NOT NULL,
    id_demandeur_reservation_topo INTEGER NOT NULL,
    PRIMARY KEY (id_reservation_topo),
    CONSTRAINT fk_id_topo_reservation_topo FOREIGN KEY (id_topo_reservation_topo) REFERENCES tb_topo(id_topo) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk2_id_proprietaire_topo FOREIGN KEY (id_proprietaire_topo) REFERENCES tb_utilisateur(id_utilisateur) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_id_demandeur_reservation_topo FOREIGN KEY (id_demandeur_reservation_topo) REFERENCES tb_utilisateur(id_utilisateur) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = INNODB;