package ua.kiev.prog.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.model.user.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}
