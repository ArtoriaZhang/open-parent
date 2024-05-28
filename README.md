### central portal
<build>
    <plugins>
        <plugin>
          <groupId>org.sonatype.central</groupId>
          <artifactId>central-publishing-maven-plugin</artifactId>
          <version>0.4.0</version>
          <extensions>true</extensions>
          <configuration>
            <publishingServerId>central</publishingServerId>
            <tokenAuth>true</tokenAuth>
          </configuration>
        </plugin>
    </plugins>
</build>

<settings>
  <servers>
    <server>
      <id>central</id>
      <username><!-- your token username --></username>
      <password><!-- your token password --></password>
    </server>
  </servers>
</settings>

<build>
    <plugins>
        <plugin>
          <groupId>org.sonatype.central</groupId>
          <artifactId>central-publishing-maven-plugin</artifactId>
          <version>0.4.0</version>
          <extensions>true</extensions>
          <configuration>
             <publishingServerId>central</publishingServerId>
             <tokenAuth>true</tokenAuth>
             <autoPublish>true</autoPublish>
             <waitUntil>published</waitUntil>
          </configuration>
        </plugin>
    <plugins>
</build>