# Backend - API de Gestion des Commandes pour Restaurants

Ce README détaille l'organisation, les prérequis, les procédures d'installation et d'exécution du projet backend basé sur Java Spring Boot dans le cadre du projet BTS SIO.

## 📚 Présentation

Le backend fournit une API REST pour gérer efficacement les utilisateurs, commandes, restaurants, réservations, notifications, et authentifications via JWT.

---

## 🚀 Prérequis

- **IDE :** IntelliJ IDEA Community Edition minimum recommandé.
- **Langage :** Java 17 (LTS).
- **Gestionnaire de dépendances :** Maven
- **Base de données :** MariaDB (ou MySQL compatible)

---

## 📁 Structure du Projet

```bash
src
├── main
│   ├── java
│   │   └── group
│   │       └── aca
│   │           └── api
│   │               ├── ApiApplication.java
│   │               ├── Controller (Gestion des requêtes HTTP)
│   │               ├── Entity (Modèles de données)
│   │               ├── Repository (Interaction avec la BDD)
│   │               ├── Security (Gestion sécurité JWT)
│   │               ├── Service (Logique métier)
│   │               ├── dto (Objets de transfert de données)
│   │               ├── SecurityConfig.java (Configuration de Spring Security)
│   │               ├── WebConfig.java
│   │               └── PasswordEncoderUpdater.java
│   └── resources
│       ├── application.properties (Configuration application)
│       ├── static
│       └── templates
└── test
    └── java
        └── group
            └── aca
                └── api
                    └── ApiApplicationTests.java (Tests unitaires)
```

---

## 🛠 Installation

### 1. Clone du projet

```bash
git clone <url-du-projet>
cd api
```

### 2. Configuration de la Base de Données

Créer une base MariaDB/MySQL et configurer les informations dans `application.properties` :

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/<nom_db>
spring.datasource.username=<user>
spring.datasource.password=<password>

spring.jpa.hibernate.ddl-auto=update
jwt.secret=<secret_jwt_base64>
jwt.expiration=3600000
```

### 3. Compilation et Installation des Dépendances

```bash
mvn clean install
```

---

## ▶️ Exécution du Projet

### En mode développement (dans l'IDE IntelliJ)

Ouvre `ApiApplication.java` et clique sur `Run`.

### Depuis le Terminal

```bash
mvn spring-boot:run
```

Le serveur sera accessible via `http://localhost:8080`

---

## 🔐 Sécurité JWT

L'authentification utilise JWT.

- Endpoint d'inscription : `/api/auth/register`
- Endpoint d'authentification : `/api/auth/login`

Les requêtes protégées doivent contenir :

```http
Authorization: Bearer <votre_token_jwt>
```

---

## 📡 API REST - Exemple d'utilisation

### Récupérer un utilisateur par ID

```javascript
async function getUserById(id) {
    try {
        const response = await fetch(`http://localhost:8080/api/user/${id}`, {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            }
        });

        if (response.ok) {
            const user = await response.json();
            console.log(user);
            return user;
        } else {
            console.error(`Erreur récupération utilisateur ${id}:`, response.status);
        }
    } catch (error) {
        console.error('Erreur réseau:', error);
    }
}
```

---

## 🧪 Tests

Les tests unitaires sont réalisés avec JUnit.

Pour exécuter les tests :

```bash
mvn test
```

---

## 📝 Bonnes pratiques

- **Nommage clair** des méthodes et variables
- **Découpage logique** par couche (Controller / Service / Repository)
- **Sécurité** rigoureuse des endpoints

---

## 🚧 Évolutions à prévoir

- Gestion des rôles et autorisations avancées.
- Optimisation des requêtes SQL.
- Tests d'intégration avancés.

---

## ⚙️ Support

Pour toute question, contacter Alexandre Baudouin.

---
