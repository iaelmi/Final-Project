package com.example.homework.components;

import com.example.homework.model.Statictics;
import com.example.homework.model.User;
import com.example.homework.repository.StatisticsRepo;
import com.example.homework.repository.UserRepo;
import com.example.homework.security.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Component
public class ServiceComponent {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private StatisticsRepo statsRepo;

    // this method saves snippet to DB
    public void saveSnippetToDB(String countryName,
                                String date, Integer totalCases, Integer totalDeaths,
                                Integer newCases) {

        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = userDetail.getUsername();
        Optional<User> user = userRepo.findByName(name);
        if (user.isPresent()) {
            Optional<Statictics> oldStats = statsRepo.findByCountryNameAndUser_id(countryName, user.get().getId());
            if (oldStats.isPresent()) {
                oldStats.get().setDate(date);
                oldStats.get().setNewCases(newCases);
                oldStats.get().setTotalCases(totalCases);
                oldStats.get().setTotalDeaths(totalDeaths);
                statsRepo.save(oldStats.get());
            } else {
                Statictics stat = new Statictics();
                stat.setCountryName(countryName);
                stat.setDate(date);
                stat.setNewCases(newCases);
                stat.setTotalCases(totalCases);
                stat.setTotalDeaths(totalDeaths);
                user.get().getStatictics().add(stat);
                stat.setUser(user.get());
                statsRepo.save(stat);
                userRepo.save(user.get());
            }
        }

    }

    // this method creates new user if not exists with the provided username
    public void createUser(String username, String password, String role) {
        Optional<User> user = userRepo.findByName(username);
        if (!user.isPresent()) {
            User newUser = new User();
            newUser.setName(username);
            newUser.setPassword(password);
            newUser.setRole(role);
            userRepo.save(newUser);
        }
    }

    // this method deletes the user by ID
    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    // this method returns snippets of user specific if role is user other wise it returns all the snippets
    public List<Statictics> getAllStats(User user) {
        if (user != null) {

            if (user.getRole().equals("ROLE_ADMIN")) {
                return statsRepo.findAll();
            } else {
                return statsRepo.findAllByUser_Id(user.getId());
            }
        }
        return null;
    }

    // this method updates snippet value in DB
    public void updateSnippetInDB(
            String countryName,
            int totalCases,
            int totalDeaths,
            int newCases,
            int statId
    ) {
        Optional<Statictics> stats = statsRepo.findById(statId);
        if (stats.isPresent()) {
            stats.get().setCountryName(countryName);
            stats.get().setTotalCases(totalCases);
            stats.get().setTotalDeaths(totalDeaths);
            stats.get().setNewCases(newCases);
            statsRepo.save(stats.get());
        }
    }

    // this method deletes snippet from DB
    public void deleteSnippeFromDB(int id) {
        statsRepo.deleteById(id);
    }

}
