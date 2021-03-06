package com.yinxiang.utils.api.doc;

import com.sun.javadoc.RootDoc;
import com.yinxiang.utils.api.generator.AbstractGrpcGenerator;
import com.yinxiang.utils.api.generator.processors.*;

/**
 * The REST API html file generator by gRPC protobuf classes.
 *
 * Can use in maven build plugin like this:
 *
 * <ol>
 *   <li>groupId: org.codehaus.mojo</li>
 *   <li>artifactId: exec-maven-plugin</li>
 *   <li>version: 3.0.0</li>
 *   <li>executions.execution.phase: compile</li>
 *   <li>executions.execution.goals.goal: java</li>
 *   <li>executions.execution.configuration.mainClass: com.yinxiang.utils.api.doc.RestApiJsonGenerator</li>
 *   <li>executions.execution.configuration.arguments.argument: ${basedir}/../test-stub/target/generated-sources/protobuf/</li>
 *   <li>executions.execution.configuration.arguments.argument: ${basedir}/../test-stub/target/classes</li>
 *   <li>executions.execution.configuration.arguments.argument: ${basedir}</li>
 *   <li>executions.execution.configuration.arguments.argument: </li>
 * </ol>
 *
 * The first argument is gRPC protobuf classpath.
 * The second argument is output path.
 * The third argument unused.
 * @author Huiyuan Fu
 */
public class RestApiJsonGenerator extends AbstractGrpcGenerator {
  protected RestApiJsonGenerator(String sourcePath) {
    super(ServiceProcessor.createFullServiceProcessor(sourcePath), new JsonBuilder());
  }

  /**
   * javadoc starter
   * @param root  root
   * @return  true
   */
  public static boolean start(RootDoc root) {
    return JavaDocCollector.start(root);
  }

  @Override
  protected String getFileFormat() {
    return ".json";
  }

  public static void main(String[] args) throws Exception {
    new RestApiJsonGenerator(args[0]).generator(args[1], args[2], args[3]);
  }
}
