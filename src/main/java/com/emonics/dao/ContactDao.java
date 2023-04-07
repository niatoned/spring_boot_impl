package com.emonics.dao;

import java.util.List;

import com.emonics.beans.Contact;

public interface ContactDao {
void saveOrUpdate(Contact contact);
void delete(int contactId);
Contact get(int contactId);
List<Contact> list();
}
