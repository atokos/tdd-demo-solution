package ee.nortal.tdd.signature;

import ee.nortal.tdd.controller.SignatureController;
import ee.nortal.tdd.dao.MobileUser;
import ee.nortal.tdd.dao.MobileUserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Base64;

@Service
public class SignatureCreator {

  @Resource
  private MobileUserDao mobileUserDao;

  public MobileSignature createSignature(SignatureRequest request) throws UserNotFoundException, UserNotActiveException {
      MobileUser user = mobileUserDao.findUser(request.getPersonIdCode());
      if (user == null) throw new UserNotFoundException();
      if (!user.isActive()) throw new UserNotActiveException();
      MobileSignature signature = new MobileSignature();
      signature.setUserFullName(user.getFullName());
      signature.setSignature(generateSignature(request));
      return signature;

  }

  private String generateSignature(SignatureRequest request) throws InvalidDocumentException{
    String document = request.getDocument();
    if (document == null || document.isEmpty()) throw new InvalidDocumentException();
    return Base64.getEncoder().encodeToString(document.getBytes());
  }
}
