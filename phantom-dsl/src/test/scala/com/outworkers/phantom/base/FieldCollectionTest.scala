/*
 * Copyright 2013 - 2017 Outworkers Ltd.
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
package com.outworkers.phantom.base

import com.outworkers.phantom.tables.TestDatabase
import org.scalatest.{FlatSpec, Matchers, ParallelTestExecution}

class FieldCollectionTest extends FlatSpec with Matchers with ParallelTestExecution {

  it should "collect objects in the same order they are written" in {
    val collected = TestDatabase.articles.columns.map(_.name).mkString(" ")
    val expected = s"${TestDatabase.articles.id.name} ${TestDatabase.articles.name.name} ${TestDatabase.articles.orderId.name}"
    collected shouldEqual expected
  }


  it should "correctly reference the same table" in {
     TestDatabase.primitives.pkey.table shouldEqual TestDatabase.primitives
  }

  it should "initialise fields by default" in {
    TestDatabase.articles.columns.size shouldEqual 3
  }
}