package ee.nortal.tdd.dao;

import ee.nortal.tdd.signature.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MobileUserDaoImpl implements MobileUserDao {

  @Override
  public MobileUser findUser(String personIdCode) throws UserNotFoundException {
    throw new UserNotFoundException();
  }
}
