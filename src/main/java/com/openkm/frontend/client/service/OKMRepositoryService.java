/**
 *  OpenKM, Open Document Management System (http://www.openkm.com)
 *  Copyright (c) 2006-2015  Paco Avila & Josep Llort
 *
 *  No bytes were intentionally harmed during the development of this application.
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.openkm.frontend.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import com.openkm.frontend.client.OKMException;
import com.openkm.frontend.client.bean.GWTFolder;

/**
 * @author jllort
 *
 */
@RemoteServiceRelativePath("Repository")
public interface OKMRepositoryService extends RemoteService {
	public GWTFolder getRootFolder() throws OKMException;
	public GWTFolder getTrashFolder() throws OKMException;
	public void purgeTrash() throws OKMException;
	public GWTFolder getTemplatesFolder() throws OKMException;
	public GWTFolder getPersonalFolder() throws OKMException;
	public GWTFolder getMailFolder() throws OKMException;
	public GWTFolder getThesaurusFolder() throws OKMException;
	public GWTFolder getCategoriesFolder() throws OKMException;
	public GWTFolder getMetadataFolder() throws OKMException;
	public String getPathByUUID(String uuid) throws OKMException;
	public String getUUIDByPath(String path) throws OKMException;
	public Boolean hasNode(String path) throws OKMException;
}