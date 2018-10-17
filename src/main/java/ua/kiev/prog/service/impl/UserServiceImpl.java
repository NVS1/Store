package ua.kiev.prog.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kiev.prog.model.user.Account;
import ua.kiev.prog.model.user.Address;
import ua.kiev.prog.repos.AccountRepo;
import ua.kiev.prog.repos.AddressRepo;
import ua.kiev.prog.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final AccountRepo accountRepo;
    private final AddressRepo addressRepo;

    public UserServiceImpl(AccountRepo accountRepo, AddressRepo addressRepo) {
        this.accountRepo = accountRepo;
        this.addressRepo = addressRepo;
    }
    @Transactional
    @Override
    public Account getUserById(Long id) {
        return accountRepo.getOne(id);
    }
    @Transactional
    @Override
    public Account findUserByLogin(String login) {
        return accountRepo.findAccountByLogin(login);
    }
    @Transactional
    @Override
    public Page<Account> findAllUsers(Pageable pageable) {
        return accountRepo.findAll(pageable);
    }
    @Transactional
    @Override
    public boolean createUser(Account account) {
        if (findUserByLogin(account.getLogin())!=null){
            return false;
        }
        accountRepo.save(account);
        return true;
    }
    @Transactional
    @Override
    public void updateUser(Account account) {
        accountRepo.save(account);
    }
    @Transactional
    @Override
    public void updateAddress(Address address) {
        addressRepo.save(address);
    }
    @Transactional
    @Override
    public void addAddress(Address address) {
        addressRepo.save(address);
    }
    @Transactional
    @Override
    public void deleteUser(Account account) {
        accountRepo.delete(account);
    }
}
