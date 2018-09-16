package labs.rr.io.elearning.helper;

import java.text.ParseException;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import labs.rr.io.elearning.entity.Account;
import labs.rr.io.elearning.entity.Contact;
import labs.rr.io.elearning.entity.Profile;
import labs.rr.io.elearning.request.AccountRequest;
import labs.rr.io.elearning.request.ContactRequest;
import labs.rr.io.elearning.request.ProfileRequest;
import labs.rr.io.elearning.util.DateUtil;

/**
 * Classe auxiliar ao servico de conta
 * 
 * @author regis.rocha
 *
 */
public class AccountHelper {

	/**
	 * Converter AccountRequest para Account
	 * 
	 * @param accountRequest - AccountRequest
	 * 
	 * @return Account
	 */
	public static Account convertToEntity(final AccountRequest accountRequest) {
		final Account acc = new Account();
		
		if (accountRequest != null) {
			acc.setEmail(accountRequest.getEmail());
			acc.setPassword(accountRequest.getPassword());

			acc.setContacts(convertContactsToEntity(accountRequest.getContacts()));
			acc.setProfile(convertProfileToEntity(accountRequest.getProfile()));
		}
		
		return acc;
	}

	
	/**
	 * Converte contatos request para contatos entity
	 * 
	 * @param request 		- ProfileRequest
	 * @param accRequest 	- AccountRequest
	 * 
	 * @return Set<Contact>
	 * 
	 * @throws ParseException 
	 */
	private static Profile convertProfileToEntity(final ProfileRequest request, final AccountRequest accRequest) throws ParseException {
		if (accRequest != null) {
			final Profile p = new Profile();
			
			p.setAccount(new Account(accRequest.getEmail()));
			p.setBirthdate(DateUtil.parseStringToDate(request.getBirthdate()));
			p.setGender(request.getGender());
			p.setName(request.getName());
			
			if (StringUtils.isNotBlank(request.getPhotoBase64())) {
				p.setPhoto(Base64.getDecoder().decode(request.getPhotoBase64()));
			}
			
			return p;
		}
		
		return null;
	}
	

	/**
	 * Converte contatos request para contatos entity
	 * 
	 * @param contacts - Set<ContactRequest>
	 * 
	 * @return Set<Contact>
	 */
	private static Set<Contact> convertContactsToEntity(final Set<ContactRequest> contacts) {
		if (contacts != null) {
			final Set<Contact> listContact = new HashSet<>();
			contacts.forEach(c -> {
				listContact.add(convertContactToEntity(c));
			});
			
			return listContact;
		}
		
		return null;
	}
	

	/**
	 * Converte contato request para contato entity 
	 * 
	 * @param request - ContactRequest
	 * 
	 * @return Contact
	 */
	private static Contact convertContactToEntity(final ContactRequest request) {
		final Contact  contact = new Contact();
		
		contact.setDddCode(request.getDddCode());
		contact.setDdiCode(request.getDdiCode());
		contact.setDescription(request.getDescription());
		contact.setId(request.getId());
		contact.setPhoneNumber(request.getPhoneNumber());
		contact.setSecondaryEmail(request.getSecondaryEmail());
		
		return contact;
	}
}
