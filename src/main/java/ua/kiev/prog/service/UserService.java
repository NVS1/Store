package ua.kiev.prog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.kiev.prog.model.user.Account;
import ua.kiev.prog.model.user.Address;

@Service
public interface UserService {
    Account getUserById (Long id);
    Account findUserByLogin (String login);
    Page<Account> findAllUsers (Pageable pageable);
    boolean createUser (String login, String password);
    void updateUser (Account account);
    void updateAddress(Address address);
    void addAddress (Address address);
}
