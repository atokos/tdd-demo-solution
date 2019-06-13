package ee.nortal.tdd.controller;

import ee.nortal.tdd.signature.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("signature")
public class SignatureController {

  @Resource
  private SignatureCreator signatureCreator;

  @RequestMapping(name = "create", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
  public MobileSignature createSignature(@RequestBody SignatureRequest request) {
    return signatureCreator.createSignature(request);
  }

  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse handleUserNotFound() {
    return new ErrorResponse("USER_NOT_FOUND");
  }

  @ExceptionHandler(InvalidDocumentException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse handleInvalidDocument() {
    return new ErrorResponse("INVALID_DOCUMENT");
  }

  @ExceptionHandler(UserNotActiveException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse handleUserNotActive() {
    return new ErrorResponse("USER_NOT_ACTIVE");
  }

}
