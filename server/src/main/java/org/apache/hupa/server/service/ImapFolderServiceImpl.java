<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> remove both of gwt-representer and gwt-dispatch dependencies, add license headers to all new files
/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

<<<<<<< HEAD
=======
>>>>>>> Allow client can use the domain entity interface.
=======
>>>>>>> remove both of gwt-representer and gwt-dispatch dependencies, add license headers to all new files
package org.apache.hupa.server.service;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
<<<<<<< HEAD

import javax.mail.Folder;
import javax.mail.MessagingException;

import org.apache.hupa.shared.data.ImapFolderImpl;
import org.apache.hupa.shared.domain.ImapFolder;
import org.apache.hupa.shared.domain.User;

import com.sun.mail.imap.IMAPStore;

public class ImapFolderServiceImpl extends AbstractService implements ImapFolderService {


	public List<ImapFolder> requestFolders() throws Exception {
		User user = getUser();
		try {
			IMAPStore store = cache.get(user);
			com.sun.mail.imap.IMAPFolder folder = (com.sun.mail.imap.IMAPFolder) store.getDefaultFolder();
			
			// List of mail 'root' imap folders 
			List<ImapFolder> imapFolders = new ArrayList<ImapFolder>();
			// Create IMAPFolder tree list
			for (Folder f : folder.list()) {
				ImapFolder imapFolder = createIMAPFolder(f);
				imapFolders.add(imapFolder);
				walkFolders(f, imapFolder);
			}
			return imapFolders;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to get folders for User " + user);
		}
	}

	/**
	 * Walk through the folder's sub-folders and add sub-folders to current
	 * imapFolder
	 * 
	 * @param folder Folder to walk
	 * @param imapFolder Current IMAPFolder
	 * @throws MessagingException If an error occurs
	 */
	private void walkFolders(Folder folder, ImapFolder imapFolder) throws MessagingException {
		for (Folder f : folder.list()) {
			ImapFolder iFolder = createIMAPFolder(f);
			imapFolder.getChildren().add(iFolder);
			walkFolders(f, iFolder);
		}
	}

	/**
	 * Create a new IMAPFolder from the given Folder
	 * 
	 * @param folder Current folder
	 * @return imapFolder Created IMAPFolder
	 * @throws Exception If an error occurs
	 * @throws MessagingException If an error occurs
	 */
	private ImapFolder createIMAPFolder(Folder folder) {

		String fullName = folder.getFullName();
		String delimiter;
		ImapFolder iFolder = null;

		try {
			delimiter = String.valueOf(folder.getSeparator());
			iFolder = new ImapFolderImpl(fullName);
			iFolder.setDelimiter(delimiter);
			if ("[Gmail]".equals(folder.getFullName()))
				return iFolder;
			iFolder.setMessageCount(folder.getMessageCount());
			iFolder.setSubscribed(folder.isSubscribed());
			iFolder.setUnseenMessageCount(folder.getUnreadMessageCount());
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return iFolder;
	}
=======
import java.util.Properties;
=======
>>>>>>> Make chechsession and login work with RF, with refactoring fetch folders.

import javax.mail.Folder;
import javax.mail.MessagingException;

import org.apache.hupa.shared.data.ImapFolderImpl;
import org.apache.hupa.shared.domain.ImapFolder;
import org.apache.hupa.shared.domain.User;

import com.sun.mail.imap.IMAPStore;

public class ImapFolderServiceImpl extends AbstractService implements ImapFolderService {


	public List<ImapFolder> requestFolders() throws Exception {
		User user = getUser();
		try {
			IMAPStore store = cache.get(user);
			com.sun.mail.imap.IMAPFolder folder = (com.sun.mail.imap.IMAPFolder) store.getDefaultFolder();
			
			// List of mail 'root' imap folders 
			List<ImapFolder> imapFolders = new ArrayList<ImapFolder>();
			// Create IMAPFolder tree list
			for (Folder f : folder.list()) {
				ImapFolder imapFolder = createIMAPFolder(f);
				imapFolders.add(imapFolder);
				walkFolders(f, imapFolder);
			}
			return imapFolders;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to get folders for User " + user);
		}
	}

<<<<<<< HEAD
    /**
     * Walk through the folder's sub-folders and add sub-folders to current imapFolder
     *   
     * @param folder Folder to walk
     * @param imapFolder Current IMAPFolder
     * @throws ActionException If an error occurs
     * @throws MessagingException If an error occurs
     */
    private void walkFolders(Folder folder, ImapFolder imapFolder) throws  MessagingException{
        for (Folder f : folder.list()) {
        	ImapFolder iFolder = createIMAPFolder(f);
            imapFolder.getChildren().add(iFolder);
            walkFolders(f, iFolder);
        }
    }

    /**
     * Create a new IMAPFolder from the given Folder
     * 
     * @param folder Current folder
     * @return imapFolder Created IMAPFolder
     * @throws ActionException If an error occurs
     * @throws MessagingException If an error occurs
     */
    private ImapFolder createIMAPFolder(Folder folder){

        String fullName = folder.getFullName();
        String delimiter;
        ImapFolder iFolder = null;
        
        try {
            System.out.println("Creating folder: " + fullName + " for user: ");
            delimiter = String.valueOf(folder.getSeparator());
            iFolder = (ImapFolder)new ImapFolderImpl(fullName);
            iFolder.setDelimiter(delimiter);
            if("[Gmail]".equals(folder.getFullName()))
                return iFolder;
            iFolder.setMessageCount(folder.getMessageCount());
            iFolder.setSubscribed(folder.isSubscribed());
            iFolder.setUnseenMessageCount(folder.getUnreadMessageCount());
        } catch (MessagingException e) {
        	e.printStackTrace();
        }
        
        return iFolder;
    }
>>>>>>> Allow client can use the domain entity interface.
=======
	/**
	 * Walk through the folder's sub-folders and add sub-folders to current
	 * imapFolder
	 * 
	 * @param folder Folder to walk
	 * @param imapFolder Current IMAPFolder
	 * @throws MessagingException If an error occurs
	 */
	private void walkFolders(Folder folder, ImapFolder imapFolder) throws MessagingException {
		for (Folder f : folder.list()) {
			ImapFolder iFolder = createIMAPFolder(f);
			imapFolder.getChildren().add(iFolder);
			walkFolders(f, iFolder);
		}
	}

	/**
	 * Create a new IMAPFolder from the given Folder
	 * 
	 * @param folder Current folder
	 * @return imapFolder Created IMAPFolder
	 * @throws Exception If an error occurs
	 * @throws MessagingException If an error occurs
	 */
	private ImapFolder createIMAPFolder(Folder folder) {

		String fullName = folder.getFullName();
		String delimiter;
		ImapFolder iFolder = null;

		try {
			System.out.println("Creating folder: " + fullName + " for user: ");
			delimiter = String.valueOf(folder.getSeparator());
			iFolder = new ImapFolderImpl(fullName);
			iFolder.setDelimiter(delimiter);
			if ("[Gmail]".equals(folder.getFullName()))
				return iFolder;
			iFolder.setMessageCount(folder.getMessageCount());
			iFolder.setSubscribed(folder.isSubscribed());
			iFolder.setUnseenMessageCount(folder.getUnreadMessageCount());
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return iFolder;
	}
<<<<<<< HEAD

	public String toString() {
		StringBuffer ret = new StringBuffer("");
		for (ImapFolder folder : imapFolders) {
			ret.append(folder.getFullName()).append("\n");
			for (ImapFolder f : folder.getChildren()) {
				childFolder(f, ret);
			}
		}
		return ret.toString();
	}

	private void childFolder(ImapFolder child, StringBuffer ret) {
		ret.append(child.getFullName()).append("\n");
		for (ImapFolder folder : child.getChildren()) {
			childFolder(folder, ret);
		}
	}
>>>>>>> Make chechsession and login work with RF, with refactoring fetch folders.
=======
>>>>>>> fix bugs, including 1)folders appending on west panel; 2)unread email folder's been frozen exception; 3)back, logout, ...buttons wired behavior.
}
