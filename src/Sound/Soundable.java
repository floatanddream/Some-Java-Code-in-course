package Sound;
import java.util.Scanner;
public interface Soundable
{
 public void PlaySound();//播放声音
 public  void  LowerSound(Boolean IS);//播放声音
 public void  Shutdown(Boolean IS);
}
class Radio implements Soundable//收音机
{

    public void PlaySound()
    {
        System.out.println("收音机播放广播电台");
    }
    public void LowerSound(Boolean IS) {
        if(IS){
            System.out.println("收音机降低音量");
        }
        else if(!IS)
        {
            System.out.println("收音机音量保持");
        }

    }


    public void Shutdown(Boolean IS) {
        if(IS){
            System.out.println("收音机关闭");
        }
        else if(!IS)
        {
            System.out.println("收音机保持开机");
        }
    }
}
class Walkman implements Soundable //随身听
{

    public void PlaySound() {
        System.out.println("随身听播放音乐：七里香");
    }

    public void LowerSound(Boolean IS) {

        if(IS){
            System.out.println("随身听降低音量");
        }
        else if(!IS)
        {
            System.out.println("随身听音量保持");
        }
    }

    public void Shutdown(Boolean IS) {

        if(IS){
            System.out.println("随身听关闭");
        }
        else if(!IS)
        {
            System.out.println("随身听保持开启");
        }
    }
}
class MobilePhone implements Soundable
{

    public void PlaySound() {
        System.out.println("手机播放铃声：哒浪浪、哒浪浪、哒浪浪");
    }


    public void LowerSound(Boolean IS) {

        if(IS){
            System.out.println("手机音量减小");
        }
        else if(!IS)
        {
            System.out.println("手机音量保持");
        }
    }


    public void Shutdown(Boolean IS) {

        if(IS){
            System.out.println("手机关闭");
        }
        else if(!IS)
        {
            System.out.println("手机保持开启");
        }
    }
}
class SampleDisplay {
    public void display(Soundable sound) {
        sound.PlaySound();
        System.out.println("是否降低音量？0-否 1-是");
        int LowerS;
        Scanner devices =new Scanner(System.in);
        LowerS=devices.nextInt();
        if(LowerS==0)
        {
            sound.LowerSound(false);
        }
        else if(LowerS==1)
        {
            sound.LowerSound(true);
        }
        System.out.println("是否关闭设备？0-否 1-是");
        int ShutD;
        Scanner DE =new Scanner(System.in);
        ShutD=DE.nextInt();
        if(ShutD==0)
        {
            sound.Shutdown(false);
        }
        else if(ShutD==1)
        {
            sound.Shutdown(true);
        }
    }
}
