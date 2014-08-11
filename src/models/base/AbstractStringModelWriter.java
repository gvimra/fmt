/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * <p>
 * {description}
 * Copyright (C) 2014  pascalpoizat
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
    public final void modelToFile(final AbstractModel model) throws IOException, IllegalResourceException {
        if (model == null || model.getResource() == null) {
            throw new IllegalResourceException("Model is not set up");
        }
        if (!model.getResource().getName().endsWith("." + getSuffix())) {
            throw new IllegalResourceException("Wrong file suffix (should be " + getSuffix() + ")");
        }
        final String apath = model.getResource().getAbsolutePath();
        final FileWriter file = new FileWriter(apath);
        if (file == null) {
            throw new IllegalResourceException("Cannot open output resource");
        }
        file.write(modelToString(model));
        file.close();
    }

    // writes model to a String
    public abstract String modelToString(AbstractModel model) throws IllegalResourceException;
}