/*
 * Copyright 2011, TAUTUA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tautua.markdownpapers.ast;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Larry Ruiz
 */
public class OpeningTag extends Tag {
    private java.util.List<TagAttribute> attributes = new ArrayList<TagAttribute>();
    private ClosingTag closingTag;


    public OpeningTag(int id) {
        super(id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.List<TagAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<TagAttribute> attributes) {
        this.attributes = attributes;
    }

    public void addAttr(TagAttribute attribute) {
        attributes.add(attribute);
    }

    public ClosingTag getClosingTag() {
        return closingTag;
    }

    public void setClosingTag(ClosingTag closingTag) {
        this.closingTag = closingTag;
    }

    public boolean isBalanced() {
        return closingTag != null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}