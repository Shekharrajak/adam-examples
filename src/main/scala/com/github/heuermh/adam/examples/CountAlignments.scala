/**
  *  Copyright 2015-2017 held jointly by the individual authors.
  * 
  *  Licensed under the Apache License, Version 2.0 (the "License");
  *  you may not use this file except in compliance with the License.
  *  You may obtain a copy of the License at
  * 
  *  http://www.apache.org/licenses/LICENSE-2.0
  * 
  *  Unless required by applicable law or agreed to in writing, software
  *  distributed under the License is distributed on an "AS IS" BASIS,
  *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  *  See the License for the specific language governing permissions and
  *  limitations under the License.
  */
package com.github.heuermh.adam.examples

import org.apache.spark.{ SparkConf, SparkContext }
import org.apache.spark.SparkContext._
import org.apache.spark.rdd.RDD
import org.bdgenomics.adam.rdd.ADAMContext._
import org.bdgenomics.adam.rdd.read.AlignmentRecordRDD
import org.bdgenomics.formats.avro.AlignmentRecord

/**
 * Count alignments ADAM example.
 * 
 * @author  Michael Heuer
 */
object CountAlignments {
  def main(args: Array[String]) {
    if (args.length < 1) {
      System.err.println("at least one argument required, e.g. foo.sam")
      System.exit(1)
    }

    val conf = new SparkConf()
      .setAppName("Count Alignments")
      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .set("spark.kryo.registrator", "org.bdgenomics.adam.serialization.ADAMKryoRegistrator")
      .set("spark.kryo.referenceTracking", "true")

    val sc = new SparkContext(conf)
    var alignments: AlignmentRecordRDD = sc.loadAlignments(args(0))
    var rdd: RDD[AlignmentRecord] = alignments.rdd

    rdd.map(rec => if (rec.getReadMapped) rec.getContigName else "unmapped")
      .map(contigName => (contigName, 1))
      .reduceByKey(_ + _)
      .foreach(println)
  }
}
