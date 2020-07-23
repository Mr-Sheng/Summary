首先在idea中对工程文件打包：mvn clean package -U -e
把 xxx-1.0-SNAPSHOT.jar上传到bjfk-rs8488.yz02
例：proxychains4 rsync -arz /Users/wuhengyu/Desktop/upload2162/kuaishou-rtc-signal-server-1.0-SNAPSHOT.jar  web_server@bjfk-rs8488.yz02::files/

跳板机连接方式：
ssh wenxinsheng@relay03.kuaishou.com
Password:邮箱密码+快手OTP

跳板机登陆bjfk-rs8488.yz02

System List
No: System
 0: All Systems
 1: AV-and-server
 2: video

Please select system:2

Device List
No: IP Address          Name(Description)
 1: 10.52.204.18        control-video(None)
 2: 10.62.34.40         control-video-docker(pg idc)

Please select device:2


登陆到bjfk-rs8488.yz02后，上传过来的xxx-1.0-SNAPSHOT.jar在目录/home/web_server/files/ 中
proxychains4 rsync -arz /Users/wuhengyu/Desktop/upload2162/kuaishou-rtc-signal-server-1.0-SNAPSHOT.jar  web_server@bjfk-rs8488.yz02::files/

此时需要将 xxx-1.0-SNAPSHOT.jar 从目录 /home/web_server/files/ 复制到 /data/web_server/project/kuaishou-runner-apps/rtcSignal-test/code中，如果原先存在同名文件，需要进行替换，此时就完成了jar包的更新.

将前一个目录中的文件拷贝到后一个目录中  cp /xxx/xxx/*.jar /xxx/xxx
删除文件  rm -f xxx.jar

接下来需要将服务重新启动：
supervisorctl -c /data/web_server/supervisord/conf/supervisord.conf
…
supervisor> restart rtcSignal-test
…
supervisor> exit

$ cd /data/web_server/logs/rtcSignal-test/
$ tail -f main.log
