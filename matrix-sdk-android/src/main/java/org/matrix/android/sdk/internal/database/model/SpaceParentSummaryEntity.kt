/*
 * Copyright 2020 The Matrix.org Foundation C.I.C.
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

package org.matrix.android.sdk.internal.database.model

import io.realm.RealmList
import io.realm.RealmObject

/**
 * Decorates room summary with space related information.
 */
internal open class SpaceParentSummaryEntity(
        /**
         * Determines whether this is the main parent for the space
         * When a user joins a room with a canonical parent, clients may switch to view the room in the context of that space,
         * peeking into it in order to find other rooms and group them together.
         * In practice, well behaved rooms should only have one canonical parent, but given this is not enforced:
         * if multiple are present the client should select the one with the lowest room ID,
         * as determined via a lexicographic utf-8 ordering.
         */
        var canonical: Boolean? = null,

        var parentRoomId: String? = null,
        // Link to the actual space summary if it is known locally
        var parentSummaryEntity: RoomSummaryEntity? = null,

        var viaServers: RealmList<String> = RealmList()

) : RealmObject() {

    companion object
}
