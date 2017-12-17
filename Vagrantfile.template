VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
	config.vm.box = "debian/jessie64"

	config.vm.provider "virtualbox" do |vb|
		vb.name = "basicDevBox"
		vb.memory = 2048
		vb.cpus = 1
	end

	config.ssh.forward_agent = true

	config.ssh.shell = "bash -c 'BASH_ENV=/etc/profile exec bash'"

	config.vm.network "forwarded_port", guest: 5000, host: 5000
	config.vm.network "private_network", ip: "10.10.10.2"

	#config.vm.synced_folder "~/.aws", "/home/vagrant/.aws" 

	config.vm.provision "shell", privileged: true, inline: <<-SHELL
		sudo apt-get update --fix-missing
		sudo apt-get -y -f install git emacs24 software-properties-common python3-pip unzip tree build-essential libssl-dev nodejs npm
		sudo -H pip3 install --upgrade pip
		sudo add-apt-repository ppa:openjdk-r/ppa
		sudo apt-get update --fix-missing
		sudo apt-get -y install openjdk-8-jdk
		sudo update-alternatives --config java
		sudo update-alternatives --config javac
		sudo apt-get update && sudo apt-get install scala 
		sudo apt-get update && sudo apt-get install sbt
	SHELL

	config.vm.provision "shell", privileged: false, inline: <<-SHELL
		echo "export PATH=~/.local/bin:$PATH" >> .profile
		source .profile
	SHELL

	#config.vm.provision "shell", privileged: false, run:"always", inline: <<-SHELL
		#commands here
	#SHELL
end
