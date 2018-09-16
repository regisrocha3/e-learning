package labs.rr.io.elearning.helper;

import java.text.ParseException;
import java.util.Base64;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import labs.rr.io.elearning.entity.Account;
import labs.rr.io.elearning.entity.Contact;
import labs.rr.io.elearning.entity.Profile;
import labs.rr.io.elearning.request.AccountRequest;
import labs.rr.io.elearning.request.ContactRequest;
import labs.rr.io.elearning.request.ProfileRequest;
import labs.rr.io.elearning.response.AccountResponse;
import labs.rr.io.elearning.response.ContactResponse;
import labs.rr.io.elearning.response.ProfileResponse;
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
	 * 
	 * @throws ParseException 
	 */
	public static Account convertToEntity(final AccountRequest accountRequest) throws ParseException {
		final Account acc = new Account();
		
		if (accountRequest != null) {
			acc.setEmail(accountRequest.getEmail());
			acc.setPassword(accountRequest.getPassword());

			acc.setContacts(convertContactsToEntity(accountRequest.getContacts()));
			acc.setProfile(convertProfileToEntity(accountRequest.getProfile(), accountRequest));
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


	
	/**
	 * Converte Account to AccountResponse
	 * 
	 * @param account - Account
	 * 
	 * @return AccountResponse
	 */
	public static AccountResponse convertToResponse(final Account account) {
		final AccountResponse res = new AccountResponse();
		
		res.setContacts(convertContactsToResponse(account.getContacts()));
		res.setEmail(account.getEmail());
		res.setProfile(convertProfileToResponse(account.getProfile()));
		
		return res;
	}


	/**
	 * Converte profile para profileResponse
	 * 
	 * @param profile - Profile
	 * 
	 * @return ProfileResponse
	 */
	private static ProfileResponse convertProfileToResponse(final Profile profile) {
		final ProfileResponse res = new ProfileResponse();

		res.setBirthdate(DateUtil.convertDateObjectToStringDate(profile.getBirthdate()));
		res.setGender(profile.getGender());
		res.setName(profile.getName());
		
		// has photo?
		if (profile.getPhoto() != null) {
			res.setPhotoBase64(Base64.getEncoder().encodeToString(profile.getPhoto()));
		}
		
		return res;
	}


	/**
	 * Converte colecao de Contatos para contato response
	 * 
	 * @param contacts - Set<Contact>
	 * 
	 * @return Set<ContactResponse>
	 */
	private static Set<ContactResponse> convertContactsToResponse(final Set<Contact> contacts) {
		if (contacts != null) {
			final Set<ContactResponse> set = new HashSet<>();
			
			contacts.forEach(c -> {
				set.add(convertContactToResponse(c));
			});
			
			return set;
		}
		
		return Collections.emptySet();
		
	}


	/**
	 * Converte Contato entity para response
	 * 
	 * @param contact - Contact
	 * 
	 * @return ContactResponse
	 */
	private static ContactResponse convertContactToResponse(final Contact contact) {
		final ContactResponse res = new ContactResponse();
		
		if (contact != null) {
			res.setDddCode(contact.getDddCode());
			res.setDdiCode(contact.getDdiCode());
			res.setDescription(contact.getDescription());
			res.setId(contact.getId());
			res.setPhoneNumber(contact.getPhoneNumber());
			res.setSecondaryEmail(contact.getSecondaryEmail());
		}
		
		return res;
	}
}
