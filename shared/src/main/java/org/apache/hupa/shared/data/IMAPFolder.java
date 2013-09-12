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

package org.apache.hupa.shared.data;

import java.util.ArrayList;

import org.apache.hupa.shared.rf.Entity;

/**
 * IMAPFolder
 * 
 */
public interface IMAPFolder extends Entity{

    public void setSubscribed(boolean subscribed);
    
    public boolean getSubscribed();
    
    
    /**
     * Get the name of the folder
     * 
     * @return name
     */
    public String getName();

    /**
     * Set the child folders 
     * 
     * @param childs
     */
    public void setChildIMAPFolders(ArrayList<IMAPFolder> childs);

    /**
     * Return the childs of this folder
     * 
     * @return childs
     */
    public ArrayList<IMAPFolder> getChildIMAPFolders();

    /**
     * Return the full name of the folder. This include the full path
     * @return Full name of the folder
     */
    public String getFullName();

    /**
     * Set the full name of the folder
     * 
     * @param fullName
     */
    public void setFullName(String fullName);

    /**
     * Set the delimiter which is used to seperate folders
     * 
     * @param delimiter
     */
    public void setDelimiter(String delimiter) ;

    /**
     * Return the delimiter
     * 
     * @return delimiter
     */
    public String getDelimiter();

    /**
     * Return the total message count of the messages that exists within this folder
     * 
     * @return msgCount
     */
    public int getMessageCount();

    /**
     * Set total message count
     * 
     * @param msgCount
     */
    public void setMessageCount(int msgCount);

    /**
     * Set the count of all unseen messages within this folder
     * 
     * @param unseenMsgCount
     */
    public void setUnseenMessageCount(int unseenMsgCount) ;

    /**
     * Return the unseen message count
     * 
     * @return unseenMsgCount
     */
    public int getUnseeMessageCount() ;

    
}
