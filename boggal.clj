;; boggle implementation
;; en clojurescript ???

(ns romain)

;; TODO pondération des lettres en français
(def alphabet "abcdefghijklmnopqrstuvwxyz")

(defn tirerUneLettre [alpha]
  ;; Tirage aléatoire d'une lettre dans une string contenant l'alphabet
  (->
   (seq alpha)
   (rand-nth)
   (str)))


(defn formerLigneLettres [tableau longueur]
  (println (str "Création d'une ligne de lettres de longueur " longueur))
  (if (not= (count tableau) longueur)
    (formerLigneLettres (conj tableau (tirerUneLettre alphabet)) longueur)
    tableau))


(formerLigneLettres [] 4)

(defn formerGrille [grille largeur hauteur]
  (println (str "Création d'une grille de dimension " largeur "x" hauteur))
  (if (not= (count grille) hauteur)
    (formerGrille (conj grille (formerLigneLettres [] largeur)) largeur hauteur)
    grille))

(formerGrille [] 4 4)
