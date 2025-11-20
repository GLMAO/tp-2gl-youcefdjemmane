### specialites SAID08

# TP Génie Logiciel : Design Patterns - Gestion de l'Emploi du Temps

Ce projet a pour objectif de développer un module de gestion des séances de cours en appliquant trois patrons de conception (Design Patterns) fondamentaux pour résoudre des problèmes de souplesse et de lisibilité dans le système actuel.

## Objectifs du TP

[cite_start]L'objectif principal était de d'améliorer et d'étendre le code existant en utilisant les patrons de conception suivants[cite: 4]:

1.**Pattern Builder** : Pour faciliter la construction d'objets `Cours` complexes et rendre le constructeur initial illisible plus clair.
2.**Pattern Observer** : Pour assurer que les étudiants inscrits et le responsable pédagogique sont notifiés automatiquement lors de la modification ou de l'annulation d'un cours[cite: 9, 10, 12].
3.**Pattern Decorator** : Pour ajouter dynamiquement et de manière cumulable des responsabilités ou des spécificités temporaires aux objets `Cours` (ex: "En ligne", "En anglais") sans modifier la structure de base de la classe[cite: 16, 17, 19].

---

## Structure du Projet et Implémentation des Patterns

### 1. Pattern Builder (Exercice 1)

***Classe `CoursBuilder`** : Offre une construction fluide de l'objet `Cours` en encapsulant les étapes de configuration des nombreux attributs (matière, enseignant, salle, date, heure, etc.)[cite: 6].
***Classe `Cours`** : Le constructeur est rendu privé (ou *package-private*) et accepte l'objet `CoursBuilder` pour garantir une création d'objet lisible et progressive.

### 2. Pattern Observer (Exercice 2)



* **Interfaces `Subject` et `Observer`** : Définissent le contrat de communication. L'interface `Observer` utilise désormais la signature `update(String action, ICours coursChange)` pour fournir un contexte complet aux observateurs.
* **Classe `GestionnaireEmploiDuTemps`** : Sert de **Subject** et gère la liste des **Observers** (`Etudiant`, `Responsable`). Il déclenche `notifyObservers()` lorsqu'un cours change d'état (modification ou ajout).
* **Classes `Etudiant` et `Responsable`** : Sont les **Observers**. Elles reçoivent la notification et agissent en conséquence (affichage du message).

### 3. Pattern Decorator (Exercice 3)

* **Interface `ICours` (Component)** : L'interface de base pour la description et la durée du cours.
* **Classe Abstraite `CoursDecorator`** : Sert de classe de base pour tous les décorateurs concrets. Elle implémente `ICours` et maintient une référence à l'objet `ICours` décoré.
* **Décorateurs Concrets** : `CoursEnLigne`, `CoursEnAnglais`, `CoursMagistral`. [cite_start]Ces classes étendent la méthode `getDescription()` de l'objet décoré pour ajouter dynamiquement un suffixe (ex: "Génie Logiciel (En ligne)")[cite: 19, 20].

---

## 🛠️ Défis Techniques et Résolutions (Rétrospective)

L'implémentation des trois patrons a soulevé des défis liés à l'interconnexion entre les structures de classes et la gestion du contexte :

### A. Fluidité et Isolation du Builder

* [cite_start]**Problème :** Assurer la lisibilité et l'atomicité de l'objet `Cours` malgré de nombreux attributs[cite: 6, 7].
* **Résolution :** L'implémentation du **Pattern Builder** résout ce problème. [cite_start]En définissant le constructeur de `Cours` comme *package-private* et en utilisant la méthode `build()` de `CoursBuilder`, on s'assure que `Cours` ne peut être créé que via un processus de construction bien défini et étape par étape[cite: 8].

### B. Passage de Contexte dans le Pattern Observer

* [cite_start]**Problème :** La notification via un simple `String` ne permettait pas aux observateurs de filtrer les informations ou de réagir de manière spécifique (par exemple, un étudiant ne doit recevoir une alerte que pour un cours auquel il est inscrit)[cite: 10, 15].
* **Résolution :** J'ai fait évoluer l'interface `Observer` vers `update(String action, ICours coursChange)`. Le `GestionnaireEmploiDuTemps` passe désormais l'objet `ICours` complet, permettant à la classe `Etudiant` d'utiliser sa liste de `coursInscrits` pour effectuer un **filtrage contextuel** avant d'afficher la notification.

### C. Cumul et Non-Modification du Composant (Decorator)

* [cite_start]**Problème :** Ajouter de nouvelles fonctionnalités aux cours (comme "En ligne") sans modifier la classe `Cours` de base, et permettre le cumul de ces caractéristiques (ex: "En ligne" *et* "En anglais")[cite: 17].
* **Résolution :** L'utilisation du **Pattern Decorator** répond directement à ce besoin. La classe abstraite `CoursDecorator` délègue toutes les méthodes à l'objet enveloppé. Les décorateurs concrets (`CoursEnLigne`, etc.) surchargent **uniquement** `getDescription()` pour ajouter leur suffixe. Ceci respecte le **principe Ouvert/Fermé (OCP)**.

---

##Consignes de Compilation et de Test

Ce projet est basé sur Maven.

### Compilation et Construction

```bash
mvn clean install


LE BONUS EST AJOUTTER SUR LE FIHCIER 
### specialites SAID08