package ua.kiev.prog.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.model.user.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
    Account findAccountByLogin(String login);
}
