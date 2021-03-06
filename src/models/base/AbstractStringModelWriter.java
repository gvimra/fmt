/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * fmt
 * Copyright (C) 2014 Pascal Poizat (@pascalpoizat)
 * emails: pascal.poizat@lip6.fr
 */

package models.base;

import java.io.FileWriter;
import java.io.IOException;

/**
 * this is the abstract class for model writers that use modelToString to achieve modelToFile
 */
public abstract class AbstractStringModelWriter extends AbstractModelWriter {

    // writes model to a file
    @Override
    public final void modelToFile(final AbstractModel model) throws IOException, IllegalResourceException, IllegalModelException {
        checkModel(model, AbstractModel.class);
        final String absolutePath = model.getResource().getAbsolutePath();
        final FileWriter file = new FileWriter(absolutePath);
        file.write(modelToString(model));
        file.close();
    }

    // writes model to a String
    public abstract String modelToString(AbstractModel model) throws IllegalResourceException, IllegalModelException;
}
