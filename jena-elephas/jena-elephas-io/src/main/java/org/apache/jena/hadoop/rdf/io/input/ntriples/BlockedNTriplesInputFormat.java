/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jena.hadoop.rdf.io.input.ntriples;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.jena.hadoop.rdf.io.input.AbstractNLineFileInputFormat;
import org.apache.jena.hadoop.rdf.io.input.readers.ntriples.BlockedNTriplesReader;
import org.apache.jena.hadoop.rdf.types.TripleWritable;


/**
 * NTriples input format where files are processed as blocks of lines rather
 * than in a line based manner as with the {@link NTriplesInputFormat} or as
 * whole files with the {@link WholeFileNTriplesInputFormat}
 * <p>
 * This provides a compromise between the higher parser setup of creating more
 * parsers and the benefit of being able to split input files over multiple
 * mappers.
 * </p>
 * 
 * 
 * 
 */
public class BlockedNTriplesInputFormat extends AbstractNLineFileInputFormat<LongWritable, TripleWritable> {

    @Override
    public RecordReader<LongWritable, TripleWritable> createRecordReader(InputSplit split, TaskAttemptContext context)
            throws IOException, InterruptedException {
        return new BlockedNTriplesReader();
    }

}
