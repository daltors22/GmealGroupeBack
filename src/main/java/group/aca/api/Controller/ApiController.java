package group.aca.api.Controller;

import group.aca.api.Entity.*;
import group.aca.api.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    /// ACTION ///

    @Autowired
    private ActionService actionService;

    @GetMapping("/action")
    public List<Action> getAllActions() {
        return actionService.getAllActions();
    }

    @GetMapping("/action/{id}")
    public Action getActionById(@PathVariable Integer id) {
        return actionService.getActionById(id);
    }

    @PostMapping("/action")
    public Action createAction(@RequestBody Action action) {
        return actionService.createAction(action);
    }


    @DeleteMapping("/action/{id}")
    public void deleteAction(@PathVariable Integer id) {
        actionService.deleteAction(id);
    }

    /// ADMINISTRATEUR ///

    @Autowired
    private AdministrateurService administrateurService;

    @GetMapping("/administrateur")
    public List<Administrateur> getAllAdministrateurs() {
        return administrateurService.getAllAdministrateurs();
    }

    @GetMapping("/administrateur/{id}")
    public Administrateur getAdministrateurById(@PathVariable Integer id) {
        return administrateurService.getAdministrateurById(id);
    }

    @PostMapping("/administrateur")
    public Administrateur createAdministrateur(@RequestBody Administrateur administrateur) {
        return administrateurService.createAdministrateur(administrateur);
    }

    @DeleteMapping("/administrateur/{id}")
    public void deleteAdministrateur(@PathVariable Integer id) {
        administrateurService.deleteAdministrateur(id);
    }

    /// ADRESSE ///

    @Autowired
    private AdresseService adresseService;

    @GetMapping("/adresse")
    public List<Adresse> getAllAdresses() {
        return adresseService.getAllAdresses();
    }

    @GetMapping("/adresse/{id}")
    public Adresse getAdresseById(@PathVariable Integer id) {
        return adresseService.getAdresseById(id);
    }

    @PostMapping("/adresse")
    public ResponseEntity<?> createAdresse(@RequestBody Adresse adresse, Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Non authentifié");
        }

        String userIdStr = (String) authentication.getPrincipal();
        Integer userId = Integer.valueOf(userIdStr);

        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Utilisateur introuvable");
        }

        // Récupération sécurisée de la ville
        Ville villeFromDb = villeService.getVilleById(adresse.getVille().getIdVille());
        if (villeFromDb == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ville non trouvée");
        }

        adresse.setUser(user);
        adresse.setVille(villeFromDb); // on relie à une entité connue

        Adresse savedAdresse = adresseService.createAdresse(adresse);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdresse);
    }



    @DeleteMapping("adresse/{id}")
    public void deleteAdresse(@PathVariable Integer id) {
        adresseService.deleteAdresse(id);
    }

    /// CLIENT ///

    @Autowired
    private ClientService clientService;

    @GetMapping("/client")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/client/{id}")
    public Client getClientById(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/client")
    public Client createClient(@RequestBody Client client) {
        return clientService.createOrUpdateClient(client);
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }

    /// COMMANDES ///

    @Autowired
    private CommandesService commandesService;

    @GetMapping("/commandes")
    public List<Commandes> getAllCommandes() {
        return commandesService.getAllCommandes();
    }

    @GetMapping("/commandes/{id}")
    public Commandes getCommandeById(@PathVariable Integer id) {
        return commandesService.getCommandeById(id);
    }

    @PostMapping("/commandes")
    public Commandes createCommande(@RequestBody Commandes commande) {
        return commandesService.createOrUpdateCommande(commande);
    }

    @DeleteMapping("/commandes/{id}")
    public void deleteCommande(@PathVariable Integer id) {
        commandesService.deleteCommande(id);
    }

    @GetMapping("/mes-commandes")
    public ResponseEntity<?> getMesCommandes(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Utilisateur non authentifié");
        }

        // Ici, le principal est un String contenant l'ID utilisateur
        String userIdStr = (String) authentication.getPrincipal();
        Integer userId = Integer.valueOf(userIdStr);

        // Récupérer les commandes associées à cet utilisateur
        List<Commandes> mesCommandes = commandesService.getCommandesByUserId(userId);
        int nbCommandes = mesCommandes.size();

        return ResponseEntity.ok(nbCommandes);
    }


    @PostMapping("/test")
    public String testPost() {
        return "POST autorisé";
    }
    /// CONNEXION ///

    @Autowired
    private ConnexionService connexionService;

    @GetMapping("/connexion")
    public List<Connexion> getAllConnexions() {
        return connexionService.getAllConnexions();
    }

    @GetMapping("/connexion/{id}")
    public Connexion getConnexionById(@PathVariable Integer id) {
        return connexionService.getConnexionById(id);
    }

    /// LIVREUR ///

    @Autowired
    private LivreurService livreurService;

    @GetMapping("/livreur")
    public List<Livreur> getAllLivreurs() {
        return livreurService.getAllLivreurs();
    }

    @GetMapping("/livreur/{id}")
    public Livreur getLivreurById(@PathVariable Integer id) {
        return livreurService.getLivreurById(id);
    }

    @PostMapping("/livreur")
    public Livreur createLivreur(@RequestBody Livreur livreur) {
        return livreurService.createOrUpdateLivreur(livreur);
    }

    @DeleteMapping("/livreur/{id}")
    public void deleteLivreur(@PathVariable Integer id) {
        livreurService.deleteLivreur(id);
    }

    /// LOGS ///

    @Autowired
    private LogsService logsService;

    @GetMapping("/logs")
    public List<Logs> getAllLogs() {
        return logsService.getAllLogs();
    }

    @GetMapping("/logs/{id}")
    public Logs getLogById(@PathVariable Integer id) {
        return logsService.getLogById(id);
    }

    @PostMapping("/logs")
    public Logs createLog(@RequestBody Logs log) {
        return logsService.createOrUpdateLog(log);
    }

    @DeleteMapping("/logs/{id}")
    public void deleteLog(@PathVariable Integer id) {
        logsService.deleteLog(id);
    }

    /// NOTIFICATION ///

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification")
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/notification/{id}")
    public Notification getNotificationById(@PathVariable Integer id) {
        return notificationService.getNotificationById(id);
    }

    @PostMapping("/notification")
    public Notification createNotification(@RequestBody Notification notification) {

        return notificationService.createOrUpdateNotification(notification);
    }

    @DeleteMapping("/notification/{id}")
    public void deleteNotification(@PathVariable Integer id) {
        notificationService.deleteNotification(id);
    }

    /// PHOTO ///

    @Autowired
    private PhotoService photoService;

    @GetMapping("/photo")
    public List<Photo> getAllPhotos() {
        return photoService.getAllPhotos();
    }

    @GetMapping("/photo/{id}")
    public Photo getPhotoById(@PathVariable Integer id) {
        return photoService.getPhotoById(id);
    }

    @PostMapping("/photo")
    public Photo createPhoto(@RequestBody Photo photo) {
        return photoService.createOrUpdatePhoto(photo);
    }

    @DeleteMapping("/photo/{id}")
    public void deletePhoto(@PathVariable Integer id) {
        photoService.deletePhoto(id);
    }

    /// PLATS ///

    @Autowired
    private PlatsService platsService;

    @GetMapping("plats")
    public List<Plats> getAllPlats() {
        return platsService.getAllPlats();
    }

    @GetMapping("/plats/{id}")
    public Plats getPlatById(@PathVariable Integer id) {
        return platsService.getPlatById(id);
    }

    @PostMapping("plats")
    public Plats createPlat(@RequestBody Plats plat) {
        return platsService.createOrUpdatePlat(plat);
    }

    @DeleteMapping("/plats/{id}")
    public void deletePlat(@PathVariable Integer id) {
        platsService.deletePlat(id);
    }

    /// PROMOTION ///

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/promotion")
    public List<Promotion> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    @GetMapping("/promotion/{id}")
    public Promotion getPromotionById(@PathVariable Integer id) {
        return promotionService.getPromotionById(id);
    }

    @PostMapping("/promotion")
    public Promotion createPromotion(@RequestBody Promotion promotion) {
        return promotionService.createOrUpdatePromotion(promotion);
    }

    @DeleteMapping("/promotion/{id}")
    public void deletePromotion(@PathVariable Integer id) {
        promotionService.deletePromotion(id);
    }

    /// RAPPORT ACTIVITE ///

    @Autowired
    private RapportActiviteService rapportActiviteService;

    @GetMapping("/rapportActivite")
    public List<RapportActivite> getAllRapports() {
        return rapportActiviteService.getAllRapports();
    }

    @GetMapping("/rapportActivite/{id}")
    public RapportActivite getRapportById(@PathVariable Integer id) {
        return rapportActiviteService.getRapportById(id);
    }

    @PostMapping("/rapportActivite")
    public RapportActivite createRapport(@RequestBody RapportActivite rapport) {
        return rapportActiviteService.createOrUpdateRapport(rapport);
    }

    @DeleteMapping("/rapportActivite/{id}")
    public void deleteRapport(@PathVariable Integer id) {
        rapportActiviteService.deleteRapport(id);
    }

    /// RESERVATION ///

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservation")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/reservation/{id}")
    public Reservation getReservationById(@PathVariable Integer id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping("/reservation")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createOrUpdateReservation(reservation);
    }

    @DeleteMapping("/reservation/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
    }

    /// RESTAURANT ///

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurant")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurantById(@PathVariable Integer id) {
        return restaurantService.getRestaurantById(id);
    }

    @PostMapping("/restaurant")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createOrUpdateRestaurant(restaurant);
    }

    @DeleteMapping("/restaurant/{id}")
    public void deleteRestaurant(@PathVariable Integer id) {
        restaurantService.deleteRestaurant(id);
    }

    /// TYPE CUISINE ///

    @Autowired
    private TypeCuisineService typeCuisineService;

    @GetMapping("/typeCuisine")
    public List<TypeCuisine> getAllTypeCuisines() {
        return typeCuisineService.getAllTypeCuisines();
    }

    @GetMapping("/typeCuisine/{id}")
    public TypeCuisine getTypeCuisineById(@PathVariable Integer id) {
        return typeCuisineService.getTypeCuisineById(id);
    }

    @PostMapping("/typeCuisine")
    public TypeCuisine createTypeCuisine(@RequestBody TypeCuisine typeCuisine) {
        return typeCuisineService.createOrUpdateTypeCuisine(typeCuisine);
    }

    @DeleteMapping("/typeCuisine/{id}")
    public void deleteTypeCuisine(@PathVariable Integer id) {
        typeCuisineService.deleteTypeCuisine(id);
    }

    /// USER ///

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    /// VILLE ///
    @Autowired
    private VilleService villeService;
    @GetMapping("/ville/{id}")
    public Ville getVilleById(@PathVariable String id) {
        return villeService.getVilleById(id);
    }

    @PutMapping("/ville/{id}")
    public Ville updateVille(@PathVariable String id, @RequestBody Ville ville) {
        ville.setIdVille(id);
        return villeService.createOrUpdateVille(ville);
    }

    @DeleteMapping("/ville/{id}")
    public void deleteVille(@PathVariable String id) {
        villeService.deleteVille(id);
    }

    @GetMapping("/ville/search")
    public List<Ville> searchVilles(@RequestParam("q") String query) {
        return villeService.searchVillesPrioritized(query);
    }



}