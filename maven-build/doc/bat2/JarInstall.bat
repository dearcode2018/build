@ rem ----- ��Ϣ -----
@ rem @filename JarInstall.bat
@ rem @version 1.0
@ rem @author qye.zheng
@ rem @description ��װ jar�� ������maven�ֿ�

@ rem @warning Ϊ�˷�ֹ���Ļ������룬�����ļ���ʱ��Ӧ�ñ���ΪANSI�����ʽ.
@ rem ################################################################################

:: ��ȡbat�ļ����ڵĴ��������������� C:
set currentDriver=%~dp0
set currentDriver=%currentDriver:~0,2%
:: ִ��������������ű������뵱ǰ�ű����ڵ�·��
%currentDriver%
cd %~dp0

:: ִ�� �������� �ű�
call Param.bat

@ rem ����
@ title ��װ jar��
@ rem ########## begin  ##########

@ rem �ر���ʾ���ʹ��������ִ��ǰ����ʾ
@ rem @ echo off
@ echo off
@ rem ��������ʾ @ echo on

@ rem ----- ����������

@ rem ----- ���������

:: ��װ class jar
mvn install:install-file -Dfile=%jarPath% -DgroupId=%groupId% -DartifactId=%artifactId% -Dversion=%version% -Dpackaging=%packaging%

:: ��װ Դ�� jar
mvn install:install-file -Dfile=%jarPath% -DgroupId=%groupId% -DartifactId=%artifactId% -Dversion=%version% -Dpackaging=%packaging% -Dclassifier=sources

@ rem pause

@ rem

@ rem
@ rem �����ʾ��Ϣ

::
:: 1) 
:: 2)
:: 3)
:: 4)
:: 5)
:: 6)
:: 7)
:: 8)
:: 9)
:: 10)

:: �ڳ����ĩβ�����Ը���ִ�еĽ��(�ɹ���ʧ��) ������ʾ��Ϣ���ɹ�����ֱ��ִ��exit����ʧ��
:: ����ִ��pause��Ȼ�����ͨ������̨�����Ϣ�����ԡ���λ����.
:: �����ڳ���������һ���ɹ���ʧ�ܵı�־-����ֵ���������������ִ������.

@ rem echo
@ rem exit
@ rem ########## end of ##########

@ rem ע��˵��: @ rem ע������  ���� :: ע������
@ rem rem ������ð�� ���� ������дע��
